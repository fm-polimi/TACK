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

public class ZotRunner {

	private final String zotEncoding;
	private final PrintStream out;

	private long satTime;

	private double checkingspace;

	private float checkingtime;

	private boolean parallel;

	/**
	 * 
	 * @param zotEncoding
	 *            the zotEncoding to be verified
	 */
	public ZotRunner(String zotEncoding, PrintStream out) {
		this(zotEncoding,out,false);
	}

	public ZotRunner(String zotEncoding, PrintStream out, boolean parallel) {
		Preconditions.checkNotNull(zotEncoding, "the zotEncoding cannot be null");
		this.zotEncoding = zotEncoding;
		this.out = out;
		this.parallel = parallel;
	}

	public boolean run() throws IOException, ZotException {
		String lispFile = "tmp.zot";

		out.println("Writing the zot file");
		FileUtils.writeStringToFile(new File(lispFile), zotEncoding);

		out.println("Considering the file " + new File(lispFile).getAbsolutePath());
		String[] command = { "zot", lispFile };
		String[] parallelizeCommand = {"/bin/bash", "-c", "cat output.smt.txt "+
				(parallel ? "| sed -E 's/\\(! smt [[:alnum:][:blank:]:_\\.]*/(par-or & :random-seed 1) & :random-seed 2)/'" : "")+
				" > tmp.smt.txt; mv tmp.smt.txt output.smt.txt"};
		String[] z3Command = { "z3", "-smt2", "output.smt.txt" };

		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		ProcessBuilder builder = new ProcessBuilder(command);
		ProcessBuilder parallelizeBuilder = new ProcessBuilder(parallelizeCommand);
		ProcessBuilder z3Builder = new ProcessBuilder(z3Command);
		builder.redirectErrorStream(true);
		Process p = builder.start();

		InputStream stdout = p.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
		boolean sat = true;

		boolean resultfound = false;

		String line;
		while ((line = reader.readLine()) != null) {

			if (line.contains("---UNSAT---")) {
				sat = false;
				resultfound = true;
			}
			if (line.contains("---SAT---")) {
				sat = true;
				resultfound = true;
			}

			String resultTime = " seconds of real time";
			if (line.contains(resultTime)) {
				String extracted = line.substring(new String("   ").length() - 1, line.indexOf(resultTime)).replace(",",
						"");
				this.satTime = (long) (Float.parseFloat(extracted) * 1000.0);
			}
			//if (line.contains(" bytes consed")) {
			//	this.checkingspace = new OutputSpaceParser().getSpace();
			//}
			// if(line.contains("seconds of real time")){
			// out.println("Verification time:" +line.subSequence(0,
			// line.indexOf("seconds of real time")));
			// }

			// if (resultfound) {
			// out.println("Stdout: " + line);
			// }
		}
		if (!parallel) {
			if (!resultfound) {
				throw new ZotException("Problems in ZOT detected");
			}
			out.print("Zot ends");
			timer.stop();
			this.checkingtime = timer.elapsed(TimeUnit.MILLISECONDS);

			return sat;
		}

		timer.reset();
		try {
			int retval = parallelizeBuilder.start().waitFor();
			if (retval != 0) throw new Exception();
		} catch (Exception e) {
			throw new ZotException("Problems in ZOT detected");
		}
		timer.start();
		Process z = z3Builder.start();
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
