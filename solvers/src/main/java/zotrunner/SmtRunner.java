package zotrunner;

import com.google.common.base.Stopwatch;
import config.Config;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class SmtRunner {

    private final String encoding;
    private final Config config;
    private final PrintStream out;

    private long satTime;
    private float checkingtime;


    public SmtRunner(String encoding, Config config, PrintStream out) {
        this.encoding = encoding;
        this.config = config;
        this.out = out;
    }

    public boolean run() throws IOException {
        String file = "tmp.smt";
        FileUtils.writeStringToFile(new File(file), encoding);
        String[] command = {"z3", "-smt2", file};

        Stopwatch timer = Stopwatch.createUnstarted();
        ProcessBuilder builder = new ProcessBuilder(command);
        timer.start();
        builder.redirectErrorStream(true);
        Process p = builder.start();
        InputStream stdout = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
        boolean sat = true;

        boolean resultfound = false;

        String line;
        while ((line = reader.readLine()) != null) {

            if (line.contains("unsat")) {
                out.println("unsat");
                sat = true;
                resultfound = true;
                continue;
            }
            if (line.contains("sat")) {
                out.println("sat");
                sat = false;
                resultfound = true;
                continue;
            }

            String resultTime = " seconds of real time";
            if (line.contains(resultTime)) {
                String extracted = line.substring(new String("   ").length() - 1, line.indexOf(resultTime)).replace(",",
                        "");
                this.satTime = (long) (Float.parseFloat(extracted) * 1000.0);
            }
             if(line.contains("seconds of real time")){
             out.println("Verification time:" +line.subSequence(0,
             line.indexOf("seconds of real time")));
             }
             
        }

        if (!resultfound) {
            throw new IOException("Problems in SMT solver detected");
        }
        out.print("Zot ends\n");
        timer.stop();
        this.checkingtime = timer.elapsed(TimeUnit.MILLISECONDS);

        return sat;

    }

}
