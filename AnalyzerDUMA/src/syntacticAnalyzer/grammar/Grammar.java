package syntacticAnalyzer.grammar;

import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CORBA.OMGVMCID;

import lexicalAnalyzer.Token;
import lexicalAnalyzer.TokenCategory;
import syntacticAnalyzer.grammar.NonTerminal;
import syntacticAnalyzer.grammar.NonTerminalName;
import syntacticAnalyzer.grammar.Derivation;
import syntacticAnalyzer.grammar.Grammar;

public class Grammar {

	private static Grammar grammarSingleton;
	private ArrayList<Derivation> grammarMap;
	private Derivation derivationAux;

	public static final int EXPRESSION = 114;

	private Grammar() {

		grammarMap = new ArrayList<Derivation>();
		loadGrammar();

	}

	public static Grammar getInstance() {
		if (grammarSingleton == null) {
			grammarSingleton = new Grammar();
		}
		return grammarSingleton;
	}

	public ArrayList<Derivation> getGrammarMap() {
		return grammarMap;
	}

	private void loadGrammar() {

		// (1) 'prDuma' 'cteSermo' BLOCK
		derivationAux = new Derivation();
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PRDUMA),
				new Terminal(TokenCategory.CTESERMO),
				new NonTerminal(NonTerminalName.BLOCK));
		grammarAddDerivation(derivationAux);
		
		
		// (2) BLOCKNAME SCOPE FUNCTIONS
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.BLOCKNAME),
				new NonTerminal(NonTerminalName.SCOPE),
				new NonTerminal(NonTerminalName.FUNCTIONS));
		grammarAddDerivation(derivationAux);
		
		// (3) ‘prConst’
		derivationAux.addSymbol(new Terminal(TokenCategory.PRCONST));
		grammarAddDerivation(derivationAux);
		
		//(4) ‘prVar’
		derivationAux = new Derivation();
		derivationAux.addSymbol(new Terminal(TokenCategory.PRVAR));
		grammarAddDerivation(derivationAux);
		
		// (5) ‘prFun’
		derivationAux = new Derivation();
		derivationAux.addSymbol(new Terminal(TokenCategory.PRFUN));
		grammarAddDerivation(derivationAux);
		
		//(6) RETURNTYPE ‘id’ PARAMS SCOPE FUNCTIONS
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.RETURNTYPE),
				new Terminal(TokenCategory.ID), 
				new NonTerminal(NonTerminalName.PARAMS),
				new NonTerminal(NonTerminalName.SCOPE),
				new NonTerminal(NonTerminalName.FUNCTIONS));		
		grammarAddDerivation(derivationAux);

		//(7) Ɛ
		grammarAddDerivation(null);

		//(8) ‘paramBegin’ PARAMSFAT
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PARAMBEGIN), new NonTerminal(NonTerminalName.PARAMSFAT));
		grammarAddDerivation(derivationAux);

		//(9) ‘paramEnd’
		derivationAux.addSymbol(new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		//(10) LISTPARAMS ‘paramEnd’
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.LISTPARAMS), new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		// (11)TYPE NAME LISTPARAMSFAT
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.TYPE), new NonTerminal(NonTerminalName.NAME), new NonTerminal(NonTerminalName.LISTPARAMSFAT));
		grammarAddDerivation(derivationAux);

		// (12) ‘sepVirg’ LISTPARAMS
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.SEPVIRG), new NonTerminal(NonTerminalName.LISTPARAMS));
		grammarAddDerivation(derivationAux);

		//(13) Ɛ
		grammarAddDerivation(null);

		// (14) TYPE RETURNTYPEFAT
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.TYPE),
				new NonTerminal(NonTerminalName.RETURNTYPEFAT));
		grammarAddDerivation(derivationAux);

		//(15) ‘vetBegin’ ‘vetEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.VETBEGIN),
				new Terminal(TokenCategory.VETEND));
		grammarAddDerivation(derivationAux);

		//(16) Ɛ
		grammarAddDerivation(null);

		//(17) ‘tdInanis’
		derivationAux.addSymbol(new Terminal(TokenCategory.TDINANIS));
		grammarAddDerivation(derivationAux);

		//(18) ‘tdInt’
		derivationAux.addSymbol(new Terminal(TokenCategory.TDINT));
		grammarAddDerivation(derivationAux);

		//(19) ‘tdReal’ 
		derivationAux.addSymbol(new Terminal(TokenCategory.TDREAL));
		grammarAddDerivation(derivationAux);

		//(20) ‘tdLit
		derivationAux.addSymbol(new Terminal(TokenCategory.TDLIT));
		grammarAddDerivation(derivationAux);

		//(21) ‘tdBool’
		derivationAux.addSymbol(new Terminal(TokenCategory.TDBOOL));
		grammarAddDerivation(derivationAux);

		//(22) ‘tdSermo’
		derivationAux.addSymbol(new Terminal(TokenCategory.TDSERMO));
		grammarAddDerivation(derivationAux);

		//(23) ‘cteNumInt’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTENUMINT));
		grammarAddDerivation(derivationAux);

		//(24) ‘cteNumReal’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTENUMREAL));
		grammarAddDerivation(derivationAux);

		//(25) ‘cteLit’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTELIT));
		grammarAddDerivation(derivationAux);

		//(26) ‘cteSermo’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTESERMO));
		grammarAddDerivation(derivationAux);

		//(27) ‘cteBool’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTEBOOL));
		grammarAddDerivation(derivationAux);
		
		//(28) ‘id’ NAMEFAT NAMER NAME
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.ID),
				new NonTerminal(NonTerminalName.NAMEFAT),
				new NonTerminal(NonTerminalName.NAMER),
				new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);

		// (29) Ɛ
		grammarAddDerivation(null);

		//(30) ‘sepVirg’
		derivationAux.addSymbol(new Terminal(TokenCategory.SEPVIRG));
		grammarAddDerivation(derivationAux);

		//(31) Ɛ
		grammarAddDerivation(null);

		//(32) ‘vetBegin’ A ‘vetEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.VETBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.VETEND));
		grammarAddDerivation(derivationAux);

		// (33) Ɛ 
		grammarAddDerivation(null);

		// (34) ‘escBegin’ COMMANDS ‘escEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.ESCBEGIN),
				new NonTerminal(NonTerminalName.COMMANDS),
				new Terminal(TokenCategory.ESCEND));
		grammarAddDerivation(derivationAux);

		//(35) CMD ‘termCmd’ COMMANDS
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.CMD),
				new Terminal(TokenCategory.TERMCMD),
				new NonTerminal(NonTerminalName.COMMANDS));
		grammarAddDerivation(derivationAux);

		//(36) Ɛ
		grammarAddDerivation(null);

		//(37) DECLARATION
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.DECLARATION));
		grammarAddDerivation(derivationAux);

		//(38) ‘id’ CMDFAT
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.ID),
				new NonTerminal(NonTerminalName.CMDFAT));
		grammarAddDerivation(derivationAux);
		
		//(39) WRITE
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.WRITE));
		grammarAddDerivation(derivationAux);

		//(40) READ
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.READ));
		grammarAddDerivation(derivationAux);

		//(41) IFELSE
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.IFELSE));
		grammarAddDerivation(derivationAux);

		//(42) WHILE
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.WHILE));
		grammarAddDerivation(derivationAux);

		//(43) DOWHILE
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.DOWHILE));
		grammarAddDerivation(derivationAux);

		//(44) FOR
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.FOR));
		grammarAddDerivation(derivationAux);

		//(45) RETURN
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.RETURN));
		grammarAddDerivation(derivationAux);

		//(46) RETURNTYPE NAME DECLARATIONFAT
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.RETURNTYPE),
				new NonTerminal(NonTerminalName.NAME),
				new NonTerminal(NonTerminalName.DECLARATIONFAT));
		grammarAddDerivation(derivationAux);

		//(47) ‘prMatrix’ TYPE NAME
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PRMATRIX),
				new NonTerminal(NonTerminalName.TYPE),
				new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);

		//(48) PARAMS
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.PARAMS));
		grammarAddDerivation(derivationAux);
		
		// (115) Ɛ
		grammarAddDerivation(null);

		//(49) ATTRIBUTION
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.ATTRIBUTION));
		grammarAddDerivation(derivationAux);

		//(50) FUNCCALL
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.FUNCCALL));
		grammarAddDerivation(derivationAux);

		//(51) NAMEFAT ‘instAtrib’ VALUE
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.NAMEFAT),
				new Terminal(TokenCategory.INSTATRIB),
				new NonTerminal(NonTerminalName.VALUE));
		grammarAddDerivation(derivationAux);

		//(52) ARRAY
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.ARRAY));
		grammarAddDerivation(derivationAux);

		//(53) A
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.A));
		grammarAddDerivation(derivationAux);
		
		//(54) ‘vetBegin’ ARRAYFAT
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.VETBEGIN),
				new NonTerminal(NonTerminalName.ARRAYFAT));
		grammarAddDerivation(derivationAux);

		//(55) ELEMENTS ‘vetEnd’
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.ELEMENTS),
				new Terminal(TokenCategory.VETEND));
		grammarAddDerivation(derivationAux);

		//(56) ‘vetEnd’
		derivationAux.addSymbol(new Terminal(TokenCategory.VETEND));
		grammarAddDerivation(derivationAux);

		//(57) CONSTANT ELEMENTSFAT
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.CONSTANT),
				new NonTerminal(NonTerminalName.ELEMENTSFAT));
		grammarAddDerivation(derivationAux);

		//(58) ‘sepVirg’ ELEMENTS
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.SEPVIRG),
				new NonTerminal(NonTerminalName.ELEMENTS));
		grammarAddDerivation(derivationAux);

		//(59) Ɛ
		grammarAddDerivation(null);

		//(60) ‘paramBegin’ LISTPARAMSCALL ‘paramEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.LISTPARAMSCALL) ,
				new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		//(61) ITEMPARAM LISTPARAMSCALLFAT
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.ITEMPARAM),
				new NonTerminal(NonTerminalName.LISTPARAMSCALLFAT));
		grammarAddDerivation(derivationAux);

		//(62) ‘sepVirg’  LISTPARAMSCALL
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.SEPVIRG),
				new NonTerminal(NonTerminalName.LISTPARAMSCALL));
		grammarAddDerivation(derivationAux);

		//(63) Ɛ
		grammarAddDerivation(null);

		//(64) CONSTANT
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.CONSTANT));
		grammarAddDerivation(derivationAux);

		//(65) NAME
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);

		//(66) ‘prScribo’ ‘paramBegin’ MESSAGE ‘paramEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PRSCRIBO),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.MESSAGE),
				new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		//(67) ‘prScriboln’ ‘paramBegin’ MESSAGE ‘paramEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PRSCRIBOLN),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.MESSAGE),
				new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		//(68) ‘cteSermo’ MESSAGEFAT
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.CTESERMO),
				new NonTerminal(NonTerminalName.MESSAGEFAT));
		grammarAddDerivation(derivationAux);

		//(69) NAME MESSAGEFAT
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.NAME),
				new NonTerminal(NonTerminalName.MESSAGEFAT));
		grammarAddDerivation(derivationAux);

		//(70) ‘opCon’ MESSAGE
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPCON),
				new NonTerminal(NonTerminalName.MESSAGE));
		grammarAddDerivation(derivationAux);

		//(71) Ɛ
		grammarAddDerivation(null);

		//(72) ‘prLectio’ ‘paramBegin’ NAME ‘paramEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PRLECTIO),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.NAME),
				new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		//(73) IF ELSEIF ELSE
		derivationAux.addDerivationSymbols(new NonTerminal(NonTerminalName.IF),
				new NonTerminal(NonTerminalName.ELSEIF),
				new NonTerminal(NonTerminalName.ELSE));
		grammarAddDerivation(derivationAux);

		//(74) ‘selSi’ ‘paramBegin’ A ‘paramEnd’ SCOPE
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.SELSI),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.PARAMEND),
				new NonTerminal(NonTerminalName.SCOPE));
		grammarAddDerivation(derivationAux);

		//(75) ‘selSialiud’ ‘paramBegin’ A ‘paramEnd’ SCOPE ELSEIF
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.SELSIALIUD),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.PARAMEND),
				new NonTerminal(NonTerminalName.SCOPE),
			new NonTerminal(NonTerminalName.ELSEIF));
		grammarAddDerivation(derivationAux);

		//(76) Ɛ
		grammarAddDerivation(null);

		//(77) ‘selAliud’ SCOPE
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.SELALIUD),
				new NonTerminal(NonTerminalName.SCOPE));
		grammarAddDerivation(derivationAux);

		//(78) Ɛ
		grammarAddDerivation(null);
		
		//(79) ‘repDum’ ‘paramBegin’ A ‘paramEnd’ SCOPE
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.REPDUM),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.PARAMEND),
				new NonTerminal(NonTerminalName.SCOPE));
		grammarAddDerivation(derivationAux);

		//(80) ‘repFacite’ SCOPE ‘repDum’ ‘paramBegin’ A ‘paramEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.REPFACITE),
				new NonTerminal(NonTerminalName.SCOPE),
				new Terminal(TokenCategory.REPDUM),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.PARAMEND)
				);
		grammarAddDerivation(derivationAux);

		//(81) ‘repQuia’  ‘id’ ‘repIn’ ‘repSpatium’ ‘paramBegin’ ITEMPARAM ‘sepVirg’ ITEMPARAM ‘sepVirg’ ITEMPARAM ‘paramEnd’ SCOPE
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.REPQUIA),
				new Terminal(TokenCategory.ID),
				new Terminal(TokenCategory.REPIN),
				new Terminal(TokenCategory.REPSPATIUM),
				new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.ITEMPARAM),
				new Terminal(TokenCategory.SEPVIRG),
				new NonTerminal(NonTerminalName.ITEMPARAM),
				new Terminal(TokenCategory.SEPVIRG),
				new NonTerminal(NonTerminalName.ITEMPARAM),
				new Terminal(TokenCategory.PARAMEND),
				new NonTerminal(NonTerminalName.SCOPE));
		grammarAddDerivation(derivationAux);

		//(82) ‘prReditus’ RETURNFAT
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PRREDITUS),
				new NonTerminal(NonTerminalName.RETURNFAT));
		grammarAddDerivation(derivationAux);

		//(83) CONSTANT
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.CONSTANT));
		grammarAddDerivation(derivationAux);

		//(84) NAME
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);

		//(85) B Ar
		derivationAux.addDerivationSymbols( new NonTerminal(NonTerminalName.B),
				new NonTerminal(NonTerminalName.Ar));
		grammarAddDerivation(derivationAux);

		//(86) 'opLogOr' B Ar
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPLOGOR),
				new NonTerminal(NonTerminalName.B),
				new NonTerminal(NonTerminalName.Ar));
		grammarAddDerivation(derivationAux);

		//(87) Ɛ
		grammarAddDerivation(null);

		//(88) C Br
		derivationAux.addDerivationSymbols( new NonTerminal(NonTerminalName.C),
				new NonTerminal(NonTerminalName.Br));
		grammarAddDerivation(derivationAux);

		//(89) 'opLogAnd' C Br
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPLOGAND),
				new NonTerminal(NonTerminalName.C),
				new NonTerminal(NonTerminalName.Br));
		grammarAddDerivation(derivationAux);

		//(90) Ɛ
		grammarAddDerivation(null);

		//(91) D Cr
		derivationAux.addDerivationSymbols( new NonTerminal(NonTerminalName.D),
				new NonTerminal(NonTerminalName.Cr));
		grammarAddDerivation(derivationAux);
		
		//(92) 'opRel2' D Cr
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPREL2),
				new NonTerminal(NonTerminalName.D),
				new NonTerminal(NonTerminalName.Cr));
		grammarAddDerivation(derivationAux);

		//(93) Ɛ
		grammarAddDerivation(null);

		//(94) E Dr	
		derivationAux.addDerivationSymbols( new NonTerminal(NonTerminalName.E),
				new NonTerminal(NonTerminalName.Dr));
		grammarAddDerivation(derivationAux);
		
		//(95) 'opRel1' E Dr
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPREL1),
				new NonTerminal(NonTerminalName.E),
				new NonTerminal(NonTerminalName.Dr));
		grammarAddDerivation(derivationAux);

		//(96) Ɛ
		grammarAddDerivation(null);

		//(97) F Er
		derivationAux.addDerivationSymbols( new NonTerminal(NonTerminalName.F),
				new NonTerminal(NonTerminalName.Er));
		grammarAddDerivation(derivationAux);

		//(98) 'opAritAd' F Er
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPARITAD),
				new NonTerminal(NonTerminalName.F),
				new NonTerminal(NonTerminalName.Er));
		grammarAddDerivation(derivationAux);

		//(99) Ɛ
		grammarAddDerivation(null);

		//(100) G Fr
		derivationAux.addDerivationSymbols( new NonTerminal(NonTerminalName.G),
				new NonTerminal(NonTerminalName.Fr));
		grammarAddDerivation(derivationAux);

		//(101) 'opAritMul' G Fr 
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPARITMUL),
				new NonTerminal(NonTerminalName.G),
				new NonTerminal(NonTerminalName.Fr));
		grammarAddDerivation(derivationAux);

		//(102) Ɛ
		grammarAddDerivation(null);

		//(103) ‘opAritUn’ G
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPARITUN),
				new NonTerminal(NonTerminalName.G));
		grammarAddDerivation(derivationAux);

		//(104) ‘opLogNeg’ G
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.OPLOGNEG),
				new NonTerminal(NonTerminalName.G));
		grammarAddDerivation(derivationAux);

		//(105) H
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.H));
		grammarAddDerivation(derivationAux);
		
		//(106) ‘paramBegin’ A ‘paramEnd’
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.PARAMBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.PARAMEND));
		grammarAddDerivation(derivationAux);

		//(107) ‘cteNumInt’ 
		derivationAux.addSymbol(new Terminal(TokenCategory.CTENUMINT));
		grammarAddDerivation(derivationAux);

		//(108) ‘cteNumReal’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTENUMREAL));
		grammarAddDerivation(derivationAux);

		//(109) ‘cteBool’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTEBOOL));
		grammarAddDerivation(derivationAux);

		// (110) ‘cteLit’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTELIT));
		grammarAddDerivation(derivationAux);
		
		//(111) ‘cteSermo’
		derivationAux.addSymbol(new Terminal(TokenCategory.CTESERMO));
		grammarAddDerivation(derivationAux);

		//(112) ’id’ Hr
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.ID),
				new NonTerminal(NonTerminalName.Hr));
		grammarAddDerivation(derivationAux);

		//(113) ‘vetBegin’ A ‘vetEnd’ 
		derivationAux.addDerivationSymbols(new Terminal(TokenCategory.VETBEGIN),
				new NonTerminal(NonTerminalName.A),
				new Terminal(TokenCategory.VETEND));
		grammarAddDerivation(derivationAux);

		//(114) Ɛ
		grammarAddDerivation(null);

	}

	private void grammarAddDerivation(Derivation derivation) {
		grammarMap.add(derivation);
		if (derivation != null) {
			derivationAux = new Derivation();
		}
	}

}
