package zotrunner;

import com.google.common.base.Stopwatch;
import config.Config;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class DryZotRunner {

    private final String encoding;
    private final Config config;
    private final PrintStream out;

    private long satTime;
    private float checkingtime;

    public DryZotRunner(String encoding, Config config, PrintStream out) {
        this.encoding = encoding;
        this.config = config;
        this.out = out;
    }

    public String run() throws IOException, ZotException {
        String file = "tmp.zot";
        FileUtils.writeStringToFile(new File(file), encoding);
        String[] command = { "zot", file };

        Stopwatch timer = Stopwatch.createUnstarted();
        ProcessBuilder builder = new ProcessBuilder(command);
        timer.start();
        builder.redirectErrorStream(true);
        Process p = builder.start();
        int count = 0;

        while (count < 120) {
            if (!p.isAlive()) break;
            try {
                p.waitFor(250, TimeUnit.MILLISECONDS);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        if (p.isAlive()) {
            p.destroy();
        }
        if (p.exitValue() != 0) {
            throw new ZotException("Problems in ZOT detected");
        }

        String smtPath = "output.smt.txt";
        return new String(Files.readAllBytes(Paths.get(smtPath)));
    }
}
