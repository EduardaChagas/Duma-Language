package main;

import lexicalAnalyzer.LexicalAnalyzer;
import lexicalAnalyzer.LexicalPrinter;

public class AnalyzerDUMA {
	private static LexicalAnalyzer lexicalAnalyzer;
	//private static SyntaticAnalyzer syntaticAnalyzer;

	private static String filePath = "files/input/shell_sort.duma";

	public AnalyzerDUMA() {

	}

	public static void main(String[] args) {

		lexicalAnalyzer = new LexicalAnalyzer(filePath);
		lexicalAnalyzer.readFile();
		LexicalPrinter.printTokens(lexicalAnalyzer);
		//syntaticAnalyzer = new SyntaticAnalyzer(lexicalAnalyzer);
		//syntaticAnalyzer.analyze();
	}
}