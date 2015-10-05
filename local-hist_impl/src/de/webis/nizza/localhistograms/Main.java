package de.webis.nizza.localhistograms;

import java.io.IOException;
import java.util.List;

import de.webis.nizza.localhistograms.svm.SvmResult;

public class Main {

	public static void main(String[] args) throws IOException {

		if (args == null || args.length == 0) {
			System.err.println("Please provide correct arguments.");
		} else {
			// String inPath = "";
			// if (args[0].equals("-i")) {
			// inPath = args[1];
			// }

			try {
				String inPath = "../corpora/C10/";
				List<SvmResult> results = new LocalHistogramAnalyzer(inPath,
						inPath).analyze();
			} catch (IOException up) {
				System.err.println("Fail. " + up.getMessage());
				throw up;
			}
		}

	}
}
