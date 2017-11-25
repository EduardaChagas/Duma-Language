package syntacticAnalyzer;

import java.util.HashMap;

import lexicalAnalyzer.TokenCategory;
import syntacticAnalyzer.grammar.NonTerminalName;

public class PredictiveTable {
	
	private HashMap<NonTerminalName, HashMap<TokenCategory, Integer>> predectiveTableMap;
	private HashMap<TokenCategory, Integer> terminaisMap;

	public PredictiveTable() {
		terminaisMap = new HashMap<TokenCategory, Integer>();
		predectiveTableMap = new HashMap<NonTerminalName, HashMap<TokenCategory, Integer>>();

		loadPredectiveTableMap();
	}

	public Integer getDerivationNumber(NonTerminalName nonTerminal,
			TokenCategory terminal) {
		return predectiveTableMap.get(nonTerminal).get(terminal);
	}

	// Tabela preditiva
	private void loadPredectiveTableMap() {
		
		terminaisMap.put(TokenCategory.PRDUMA, 0);
		predectiveTableMap.put(NonTerminalName.PROGRAM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PRCONST, 1);
		terminaisMap.put(TokenCategory.PRVAR, 1);
		terminaisMap.put(TokenCategory.PRFUN, 1);
		predectiveTableMap.put(NonTerminalName.BLOCK, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PRCONST, 2);
		terminaisMap.put(TokenCategory.PRVAR, 3);
		terminaisMap.put(TokenCategory.PRFUN, 4);
		predectiveTableMap.put(NonTerminalName.BLOCKNAME, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 5);
		terminaisMap.put(TokenCategory.TDINT, 5);
		terminaisMap.put(TokenCategory.TDREAL, 5);
		terminaisMap.put(TokenCategory.TDLIT, 5);
		terminaisMap.put(TokenCategory.TDBOOL, 5);
		terminaisMap.put(TokenCategory.TDSERMO, 5);
		//terminaisMap.put(TokenCategory.EOF, 6);
		predectiveTableMap.put(NonTerminalName.FUNCTIONS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PARAMBEGIN, 7);
		predectiveTableMap.put(NonTerminalName.PARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PARAMEND, 8);
		terminaisMap.put(TokenCategory.TDINANIS, 9);
		terminaisMap.put(TokenCategory.TDINT, 9);
		terminaisMap.put(TokenCategory.TDREAL, 9);
		terminaisMap.put(TokenCategory.TDLIT, 9);
		terminaisMap.put(TokenCategory.TDBOOL, 9);
		terminaisMap.put(TokenCategory.TDSERMO, 9);
		predectiveTableMap.put(NonTerminalName.PARAMSFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 10);
		terminaisMap.put(TokenCategory.TDINT, 10);
		terminaisMap.put(TokenCategory.TDREAL, 10);
		terminaisMap.put(TokenCategory.TDLIT, 10);
		terminaisMap.put(TokenCategory.TDBOOL, 10);
		terminaisMap.put(TokenCategory.TDSERMO, 10);
		predectiveTableMap.put(NonTerminalName.LISTPARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SEPVIRG, 11);
		terminaisMap.put(TokenCategory.PARAMEND, 12);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 13);
		terminaisMap.put(TokenCategory.TDINT, 13);
		terminaisMap.put(TokenCategory.TDREAL, 13);
		terminaisMap.put(TokenCategory.TDLIT, 13);
		terminaisMap.put(TokenCategory.TDBOOL, 13);
		terminaisMap.put(TokenCategory.TDSERMO, 13);
		predectiveTableMap.put(NonTerminalName.RETURNTYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 14);
		terminaisMap.put(TokenCategory.ID, 15);
		predectiveTableMap.put(NonTerminalName.RETURNTYPEFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 16);
		terminaisMap.put(TokenCategory.TDINT, 17);
		terminaisMap.put(TokenCategory.TDREAL, 18);
		terminaisMap.put(TokenCategory.TDLIT, 19);
		terminaisMap.put(TokenCategory.TDBOOL, 20);
		terminaisMap.put(TokenCategory.TDSERMO, 21);
		predectiveTableMap.put(NonTerminalName.TYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.CTENUMINT, 22);
		terminaisMap.put(TokenCategory.CTENUMREAL, 23);
		terminaisMap.put(TokenCategory.CTELIT, 24);
		terminaisMap.put(TokenCategory.CTESERMO, 25);
		terminaisMap.put(TokenCategory.CTEBOOL, 26);
		predectiveTableMap.put(NonTerminalName.CONSTANT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.ID, 27);
		terminaisMap.put(TokenCategory.TERMCMD, 28);
		predectiveTableMap.put(NonTerminalName.NAME, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SEPVIRG, 29);
		terminaisMap.put(TokenCategory.ID, 30);
		terminaisMap.put(TokenCategory.TERMCMD, 30);
		predectiveTableMap.put(NonTerminalName.NAMER, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 31);
		terminaisMap.put(TokenCategory.SEPVIRG, 32);
		terminaisMap.put(TokenCategory.ID, 32);
		terminaisMap.put(TokenCategory.TERMCMD, 32);
		predectiveTableMap.put(NonTerminalName.NAMEFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.ESCBEGIN, 33);
		predectiveTableMap.put(NonTerminalName.SCOPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 34);
		terminaisMap.put(TokenCategory.TDINT, 34);
		terminaisMap.put(TokenCategory.TDREAL, 34);
		terminaisMap.put(TokenCategory.TDLIT, 34);
		terminaisMap.put(TokenCategory.TDBOOL, 34);
		terminaisMap.put(TokenCategory.TDSERMO, 34);
		terminaisMap.put(TokenCategory.PRMATRIX, 34);
		terminaisMap.put(TokenCategory.ID, 34);
		terminaisMap.put(TokenCategory.PRSCRIBO, 34);
		terminaisMap.put(TokenCategory.PRSCRIBOLN, 34);
		terminaisMap.put(TokenCategory.PRLECTIO, 34);
		terminaisMap.put(TokenCategory.SELSI, 34);
		terminaisMap.put(TokenCategory.REPDUM, 34);
		terminaisMap.put(TokenCategory.REPFACITE, 34);
		terminaisMap.put(TokenCategory.REPQUIA, 34);
		terminaisMap.put(TokenCategory.PRREDITUS, 34);
		terminaisMap.put(TokenCategory.ESCEND, 35);
		predectiveTableMap.put(NonTerminalName.COMMANDS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 36);
		terminaisMap.put(TokenCategory.TDINT, 36);
		terminaisMap.put(TokenCategory.TDREAL, 36);
		terminaisMap.put(TokenCategory.TDLIT, 36);
		terminaisMap.put(TokenCategory.TDBOOL, 36);
		terminaisMap.put(TokenCategory.TDSERMO, 36);
		terminaisMap.put(TokenCategory.PRMATRIX, 36);
		terminaisMap.put(TokenCategory.ID, 37);
		terminaisMap.put(TokenCategory.PRSCRIBO, 38);
		terminaisMap.put(TokenCategory.PRSCRIBOLN, 38);
		terminaisMap.put(TokenCategory.PRLECTIO, 39);
		terminaisMap.put(TokenCategory.SELSI, 40);
		terminaisMap.put(TokenCategory.REPDUM, 41);
		terminaisMap.put(TokenCategory.REPFACITE, 42);
		terminaisMap.put(TokenCategory.REPQUIA, 43);
		terminaisMap.put(TokenCategory.PRREDITUS, 44);
		predectiveTableMap.put(NonTerminalName.CMD, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 45);
		terminaisMap.put(TokenCategory.TDINT, 45);
		terminaisMap.put(TokenCategory.TDREAL, 45);
		terminaisMap.put(TokenCategory.TDLIT, 45);
		terminaisMap.put(TokenCategory.TDBOOL, 45);
		terminaisMap.put(TokenCategory.TDSERMO, 45);
		terminaisMap.put(TokenCategory.PRMATRIX, 46);
		predectiveTableMap.put(NonTerminalName.DECLARATION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PARAMBEGIN, 47);
		terminaisMap.put(TokenCategory.TERMCMD, 114);
		predectiveTableMap.put(NonTerminalName.DECLARATIONFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 48);
		terminaisMap.put(TokenCategory.SEPVIRG, 48);
		terminaisMap.put(TokenCategory.ID, 48);
		terminaisMap.put(TokenCategory.INSTATRIB, 48);
		terminaisMap.put(TokenCategory.TERMCMD, 48);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 49);
		predectiveTableMap.put(NonTerminalName.CMDFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 50);
		terminaisMap.put(TokenCategory.SEPVIRG, 50);
		terminaisMap.put(TokenCategory.ID, 50);
		terminaisMap.put(TokenCategory.INSTATRIB, 50);
		terminaisMap.put(TokenCategory.TERMCMD, 50);
		predectiveTableMap.put(NonTerminalName.ATTRIBUTION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 51);
		terminaisMap.put(TokenCategory.OPARITMUL, 52);
		terminaisMap.put(TokenCategory.OPARITUN, 52);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 52);
		terminaisMap.put(TokenCategory.CTENUMINT, 52);
		terminaisMap.put(TokenCategory.CTENUMREAL, 52);
		terminaisMap.put(TokenCategory.CTEBOOL, 52);
		terminaisMap.put(TokenCategory.CTESERMO, 52);
		terminaisMap.put(TokenCategory.CTELIT, 52);
		terminaisMap.put(TokenCategory.ID, 52);
		predectiveTableMap.put(NonTerminalName.VALUE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 53);
		predectiveTableMap.put(NonTerminalName.ARRAY, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.CTENUMINT, 54);
		terminaisMap.put(TokenCategory.CTENUMREAL, 54);
		terminaisMap.put(TokenCategory.CTEBOOL, 54);
		terminaisMap.put(TokenCategory.CTESERMO, 54);
		terminaisMap.put(TokenCategory.CTELIT, 54);
		terminaisMap.put(TokenCategory.VETEND,55);
		predectiveTableMap.put(NonTerminalName.ARRAYFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.CTENUMINT, 56);
		terminaisMap.put(TokenCategory.CTENUMREAL, 56);
		terminaisMap.put(TokenCategory.CTEBOOL, 56);
		terminaisMap.put(TokenCategory.CTESERMO, 56);
		terminaisMap.put(TokenCategory.CTELIT, 56);
		predectiveTableMap.put(NonTerminalName.ELEMENTS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SEPVIRG, 57);
		terminaisMap.put(TokenCategory.VETEND, 58);
		predectiveTableMap.put(NonTerminalName.ELEMENTSFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PARAMBEGIN, 59);
		predectiveTableMap.put(NonTerminalName.FUNCCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TERMCMD, 60);
		terminaisMap.put(TokenCategory.CTENUMINT, 60);
		terminaisMap.put(TokenCategory.CTENUMREAL, 60);
		terminaisMap.put(TokenCategory.CTEBOOL, 60);
		terminaisMap.put(TokenCategory.CTESERMO, 60);
		terminaisMap.put(TokenCategory.CTELIT, 60);
		terminaisMap.put(TokenCategory.ID, 60);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SEPVIRG, 61);
		terminaisMap.put(TokenCategory.PARAMEND, 62);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALLFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TERMCMD, 64);
		terminaisMap.put(TokenCategory.CTENUMINT, 63);
		terminaisMap.put(TokenCategory.CTENUMREAL, 63);
		terminaisMap.put(TokenCategory.CTEBOOL, 63);
		terminaisMap.put(TokenCategory.CTESERMO, 63);
		terminaisMap.put(TokenCategory.CTELIT, 63);
		terminaisMap.put(TokenCategory.ID, 64);
		predectiveTableMap.put(NonTerminalName.ITEMPARAM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PRSCRIBO, 65);
		terminaisMap.put(TokenCategory.PRSCRIBOLN, 66);
		predectiveTableMap.put(NonTerminalName.WRITE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.CTESERMO, 67);
		terminaisMap.put(TokenCategory.TERMCMD, 68);
		terminaisMap.put(TokenCategory.ID, 68);
		predectiveTableMap.put(NonTerminalName.MESSAGE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPCON, 69);
		terminaisMap.put(TokenCategory.PARAMEND, 70);
		predectiveTableMap.put(NonTerminalName.MESSAGEFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PRLECTIO, 71);
		predectiveTableMap.put(NonTerminalName.READ, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SELSI, 72);
		predectiveTableMap.put(NonTerminalName.IFELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SELSI, 73);
		predectiveTableMap.put(NonTerminalName.IF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SELSIALIUD, 74);
		terminaisMap.put(TokenCategory.SELALIUD, 75);
		terminaisMap.put(TokenCategory.TERMCMD, 75);
		predectiveTableMap.put(NonTerminalName.ELSEIF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.SELALIUD, 76);
		terminaisMap.put(TokenCategory.TERMCMD, 77);
		predectiveTableMap.put(NonTerminalName.ELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.REPDUM, 78);
		predectiveTableMap.put(NonTerminalName.WHILE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.REPFACITE, 79);
		predectiveTableMap.put(NonTerminalName.DOWHILE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.REPQUIA, 80);
		predectiveTableMap.put(NonTerminalName.FOR, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PRREDITUS, 81);
		predectiveTableMap.put(NonTerminalName.RETURN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TERMCMD, 83);
		terminaisMap.put(TokenCategory.CTENUMINT, 82);
		terminaisMap.put(TokenCategory.CTENUMREAL, 82);
		terminaisMap.put(TokenCategory.CTEBOOL, 82);
		terminaisMap.put(TokenCategory.CTESERMO, 82);
		terminaisMap.put(TokenCategory.CTELIT, 82);
		terminaisMap.put(TokenCategory.ID, 83);
		predectiveTableMap.put(NonTerminalName.RETURNFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 84);
		terminaisMap.put(TokenCategory.OPARITUN, 84);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 84);
		terminaisMap.put(TokenCategory.CTENUMINT, 84);
		terminaisMap.put(TokenCategory.CTENUMREAL, 84);
		terminaisMap.put(TokenCategory.CTEBOOL, 84);
		terminaisMap.put(TokenCategory.CTESERMO, 84);
		terminaisMap.put(TokenCategory.CTELIT, 84);
		terminaisMap.put(TokenCategory.ID, 84);
		predectiveTableMap.put(NonTerminalName.A, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPLOGOR, 85);
		terminaisMap.put(TokenCategory.PARAMEND, 86);
		terminaisMap.put(TokenCategory.TERMCMD, 86);
		predectiveTableMap.put(NonTerminalName.Ar, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 87);
		terminaisMap.put(TokenCategory.OPARITUN, 87);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 87);
		terminaisMap.put(TokenCategory.CTENUMINT, 87);
		terminaisMap.put(TokenCategory.CTENUMREAL, 87);
		terminaisMap.put(TokenCategory.CTEBOOL, 87);
		terminaisMap.put(TokenCategory.CTESERMO, 87);
		terminaisMap.put(TokenCategory.CTELIT, 87);
		terminaisMap.put(TokenCategory.ID, 87);
		predectiveTableMap.put(NonTerminalName.B, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPLOGAND, 88);
		terminaisMap.put(TokenCategory.OPLOGOR, 89);
		terminaisMap.put(TokenCategory.PARAMEND, 89);
		terminaisMap.put(TokenCategory.TERMCMD, 89);
		predectiveTableMap.put(NonTerminalName.Br, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 90);
		terminaisMap.put(TokenCategory.OPARITUN, 90);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 90);
		terminaisMap.put(TokenCategory.CTENUMINT, 90);
		terminaisMap.put(TokenCategory.CTENUMREAL, 90);
		terminaisMap.put(TokenCategory.CTEBOOL, 90);
		terminaisMap.put(TokenCategory.CTESERMO, 90);
		terminaisMap.put(TokenCategory.CTELIT, 90);
		terminaisMap.put(TokenCategory.ID, 90);
		predectiveTableMap.put(NonTerminalName.C, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPREL2, 91);
		terminaisMap.put(TokenCategory.OPLOGAND, 92);
		terminaisMap.put(TokenCategory.OPLOGOR, 92);
		terminaisMap.put(TokenCategory.PARAMEND, 92);
		terminaisMap.put(TokenCategory.TERMCMD, 92);
		predectiveTableMap.put(NonTerminalName.Cr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 93);
		terminaisMap.put(TokenCategory.OPARITUN, 93);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 93);
		terminaisMap.put(TokenCategory.CTENUMINT, 93);
		terminaisMap.put(TokenCategory.CTENUMREAL, 93);
		terminaisMap.put(TokenCategory.CTEBOOL, 93);
		terminaisMap.put(TokenCategory.CTESERMO, 93);
		terminaisMap.put(TokenCategory.CTELIT, 93);
		terminaisMap.put(TokenCategory.ID, 93);
		predectiveTableMap.put(NonTerminalName.D, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPREL1, 94);
		terminaisMap.put(TokenCategory.OPREL2, 95);
		terminaisMap.put(TokenCategory.OPLOGAND, 95);
		terminaisMap.put(TokenCategory.OPLOGOR, 95);
		terminaisMap.put(TokenCategory.PARAMEND, 95);
		terminaisMap.put(TokenCategory.TERMCMD, 95);
		predectiveTableMap.put(NonTerminalName.Dr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 96);
		terminaisMap.put(TokenCategory.OPARITUN, 96);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 96);
		terminaisMap.put(TokenCategory.CTENUMINT, 96);
		terminaisMap.put(TokenCategory.CTENUMREAL, 96);
		terminaisMap.put(TokenCategory.CTEBOOL, 96);
		terminaisMap.put(TokenCategory.CTESERMO, 96);
		terminaisMap.put(TokenCategory.CTELIT, 96);
		terminaisMap.put(TokenCategory.ID, 96);
		predectiveTableMap.put(NonTerminalName.E, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITAD, 97);
		terminaisMap.put(TokenCategory.OPREL1, 98);
		terminaisMap.put(TokenCategory.OPREL2, 98);
		terminaisMap.put(TokenCategory.OPLOGAND, 98);
		terminaisMap.put(TokenCategory.OPLOGOR, 98);
		terminaisMap.put(TokenCategory.PARAMEND, 98);
		terminaisMap.put(TokenCategory.TERMCMD, 98);
		predectiveTableMap.put(NonTerminalName.Er, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 99);
		terminaisMap.put(TokenCategory.OPARITUN, 99);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 99);
		terminaisMap.put(TokenCategory.CTENUMINT, 99);
		terminaisMap.put(TokenCategory.CTENUMREAL, 99);
		terminaisMap.put(TokenCategory.CTEBOOL, 99);
		terminaisMap.put(TokenCategory.CTESERMO, 99);
		terminaisMap.put(TokenCategory.CTELIT, 99);
		terminaisMap.put(TokenCategory.ID, 99);
		predectiveTableMap.put(NonTerminalName.F, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITMUL, 100);
		terminaisMap.put(TokenCategory.OPARITAD, 101);
		terminaisMap.put(TokenCategory.OPREL1, 101);
		terminaisMap.put(TokenCategory.OPREL2, 101);
		terminaisMap.put(TokenCategory.OPLOGAND, 101);
		terminaisMap.put(TokenCategory.OPLOGOR, 101);
		terminaisMap.put(TokenCategory.PARAMEND, 101);
		terminaisMap.put(TokenCategory.TERMCMD, 101);
		predectiveTableMap.put(NonTerminalName.Fr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.OPARITUN, 102);
		terminaisMap.put(TokenCategory.OPLOGNEG, 103);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 104);
		terminaisMap.put(TokenCategory.CTENUMINT, 104);
		terminaisMap.put(TokenCategory.CTENUMREAL, 104);
		terminaisMap.put(TokenCategory.CTEBOOL, 104);
		terminaisMap.put(TokenCategory.CTESERMO, 104);
		terminaisMap.put(TokenCategory.CTELIT, 104);
		terminaisMap.put(TokenCategory.ID, 104);
		predectiveTableMap.put(NonTerminalName.G, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PARAMBEGIN, 105);
		terminaisMap.put(TokenCategory.CTENUMINT, 106);
		terminaisMap.put(TokenCategory.CTENUMREAL, 107);
		terminaisMap.put(TokenCategory.CTEBOOL, 108);
		terminaisMap.put(TokenCategory.CTESERMO, 110);
		terminaisMap.put(TokenCategory.CTELIT, 109);
		terminaisMap.put(TokenCategory.ID, 111);
		predectiveTableMap.put(NonTerminalName.H, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.VETBEGIN, 112);
		terminaisMap.put(TokenCategory.OPARITMUL, 113);
		terminaisMap.put(TokenCategory.OPARITAD, 113);
		terminaisMap.put(TokenCategory.OPREL1, 113);
		terminaisMap.put(TokenCategory.OPREL2, 113);
		terminaisMap.put(TokenCategory.OPLOGAND, 113);
		terminaisMap.put(TokenCategory.OPLOGOR, 113);
		terminaisMap.put(TokenCategory.PARAMEND, 113);
		terminaisMap.put(TokenCategory.TERMCMD, 113);
		predectiveTableMap.put(NonTerminalName.Hr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
	}

}
