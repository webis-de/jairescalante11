package jairescalante11;

import java.io.IOException;
import java.util.List;

import jairescalante11.svm.EnrichedSvmResult;

public class Main {

	public static void main(String[] args) throws IOException {

		if (args == null || args.length == 0) {
			System.err.println("Please provide correct arguments.");
		} else {

			String inPath = "";
			if (args[0].equals("-i")) {
				inPath = args[1];
			} else {
				inPath = "../corpora/C10/";
			}

			String outPath = "";
			if (args[2].equals("-o")) {
				outPath = args[3];
			} else {
				outPath = inPath + "output.json";
			}

			try {

				List<EnrichedSvmResult> results = new LocalHistogramAnalyzer(inPath).analyze();
				new ResultWriter(outPath).writeJsonFile(results);
			} catch (IOException up) {
				System.err.println("Fail. " + up.getMessage());
				throw up;
			}
		}

	}
}
