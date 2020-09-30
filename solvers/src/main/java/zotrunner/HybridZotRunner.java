package zotrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;

import solvers.output.OutputSpaceParser;

public class HybridZotRunner {

    private final String TAz3Encoding;
    private final String mitliZotEncoding;
    private final PrintStream out;

    private long satTime;

    private double checkingspace;

    private float checkingtime;

    private final boolean parallel;

    /**
     *
     * @param mitliZotEncoding
     *            the zotEncoding to be verified
     */
    public HybridZotRunner(String TAz3Encoding, String mitliZotEncoding, PrintStream out) {
        this(TAz3Encoding,mitliZotEncoding,out,false);
    }

    public HybridZotRunner(String TAz3Encoding, String mitliZotEncoding, PrintStream out, boolean parallel) {
        Preconditions.checkNotNull(mitliZotEncoding, "the zotEncoding cannot be null");
        this.TAz3Encoding = TAz3Encoding;
        this.mitliZotEncoding = mitliZotEncoding;
        this.out = out;
        this.parallel = parallel;
    }

    public boolean run() throws IOException, ZotException {
        String lispFile = "tmp.zot";
        String taFile = "smt-ta.txt";

        out.println("Writing the zot file");
        FileUtils.writeStringToFile(new File(lispFile), mitliZotEncoding);
        FileUtils.writeStringToFile(new File(taFile), TAz3Encoding);

        out.println("Considering the file " + new File(lispFile).getAbsolutePath());
        String[] command = { "zot", lispFile };
        String[] combineCommand = { "/bin/bash", "-c", "head -n -2 output.smt.txt > tmp.smt.txt;"+
                " cat smt-ta.txt >> tmp.smt.txt; tail -n -2 output.smt.txt >> tmp.smt.txt;"+
                " cat tmp.smt.txt "+ (parallel ? "| sed -E 's/\\(! smt [[:alnum:][:blank:]:_\\.]*/(par-or & :random-seed 1) & :random-seed 2)/'" : "")+
                " > output.smt.txt; rm tmp.smt.txt; rm smt-ta.txt"};
        String[] z3Command = { "z3", "-smt2", "output.smt.txt" };

        Stopwatch timer = Stopwatch.createUnstarted();
        ProcessBuilder builder = new ProcessBuilder(command);
        ProcessBuilder combineBuilder = new ProcessBuilder(combineCommand);
        ProcessBuilder z3Builder = new ProcessBuilder(z3Command);
        timer.start();
        builder.redirectErrorStream(true);
        Process p = builder.start();

        InputStream stdout = p.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
        boolean sat = true;

        int count = 0;
        String line;
        int exitval;

        while (count < 60) {
            if (!p.isAlive()) break;
            try {
                p.waitFor(1, TimeUnit.SECONDS);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        if (p.isAlive()) {
            p.destroy();
        }
        exitval = p.exitValue();

        if (exitval != 0) {
            throw new ZotException("Problems in ZOT detected");
        }
        out.print("Zot ends");
        timer.stop();
        this.checkingtime = timer.elapsed(TimeUnit.MILLISECONDS);

        timer.reset();
        try {
            int retval = combineBuilder.start().waitFor();
            if (retval != 0) throw new Exception();
        } catch (Exception e) {
            throw new ZotException("Problems in ZOT detected");
        }
        timer.start();
        Process z = z3Builder.start();
        boolean resultfound;
        resultfound = false;
        stdout = z.getInputStream();
        reader = new BufferedReader(new InputStreamReader(stdout));
        while ((line = reader.readLine()) != null) {
            if (line.contains("(error")) continue;
            if (line.startsWith("unsat")) {
                resultfound = true;
                sat = false;
            }
            if (line.startsWith("sat")) {
                resultfound = true;
                sat = true;
            }
        }
        timer.stop();
        this.satTime = timer.elapsed(TimeUnit.MILLISECONDS);

        if (!resultfound) {
            throw new ZotException("Problems in ZOT detected");
        }

        return sat;
    }

    public long getSatTime() {
        return satTime;
    }

    public double getCheckingspace() {
        return checkingspace;
    }

    public float getCheckingtime() {
        return checkingtime;
    }
}
