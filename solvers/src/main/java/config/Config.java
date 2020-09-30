package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Config {

    public final int bound;

    public static final String SOLVER_TA2SMT = "ta2smt";
    public static final String SOLVER_AE2SBVZOT = "ae2sbvzot";
    public static final String SOLVER_AE2ZOT = "ae2zot";
    public String solver = SOLVER_TA2SMT;

    public static final String LIVENESS_STRONGTRANSITION = "strongtransition";
    public static final String LIVENESS_WEAKTRANSITION = "weaktransition";
    public static final String LIVENESS_UNRESTRICTED = "unrestricted";
    public String liveness = LIVENESS_STRONGTRANSITION;

    public static final String EDGES_RIGHTCLOSED = "rightclosed";
    public static final String EDGES_OPEN = "open";
    public String edges = EDGES_RIGHTCLOSED;

    public int parallel = 1;

    public Config(File config, int bound) throws IOException {
        this.bound = bound;
        readConfig(config);
    }

    private void readConfig(File config) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(config));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("solver: ")) {
                switch (line.substring("solver: ".length())) {
                    case SOLVER_TA2SMT: solver = SOLVER_TA2SMT; break;
                    case SOLVER_AE2SBVZOT: solver = SOLVER_AE2SBVZOT; break;
                    case SOLVER_AE2ZOT: solver = SOLVER_AE2ZOT; break;
                    default: break;
                }
            } else if (line.startsWith("liveness: ")) {
                switch (line.substring("liveness: ".length())) {
                    case LIVENESS_STRONGTRANSITION: liveness = LIVENESS_STRONGTRANSITION; break;
                    case LIVENESS_WEAKTRANSITION: liveness = LIVENESS_WEAKTRANSITION; break;
                    case LIVENESS_UNRESTRICTED: liveness = LIVENESS_UNRESTRICTED; break;
                    default: break;
                }
            } else if (line.startsWith("edges: ")) {
               switch (line.substring("edges: ".length())) {
                   case EDGES_RIGHTCLOSED: edges = EDGES_RIGHTCLOSED; break;
                   case EDGES_OPEN: edges = EDGES_OPEN; break;
                   default: break;
               }
            } else if (line.startsWith("parallel: ")) {
                parallel = Integer.parseInt(line.substring("parallel: ".length()));
            }
        }
    }
}
