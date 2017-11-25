package syntacticAnalyzer.grammar;

public enum NonTerminalName {

	
	PROGRAM(1), BLOCK(2), BLOCKNAME(3), SCOPE(4), FUNCTIONS(5),
	RETURNTYPE(6), PARAMS(7), PARAMSFAT(8), LISTPARAMS(9),
	TYPE(10), NAME(11), LISTPARAMSFAT(12), RETURNTYPEFAT(13),
	CONSTANT(14), NAMEFAT(15), NAMER(16), COMMANDS(17), CMD(18),
	DECLARATION(19), CMDFAT(20), WRITE(21), READ(22), IFELSE(23),
	WHILE(24), DOWHILE(25), FOR(26), RETURN(27), ATTRIBUTION(28),
	FUNCCALL(29), VALUE(30), ARRAY(31), A(32), ARRAYFAT(33), ELEMENTS(34),
	ELEMENTSFAT(35), LISTPARAMSCALL(36), LISTPARAMSCALLFAT(37),
	ITEMPARAM(38), MESSAGE(39), MESSAGEFAT(40), IF(41), ELSEIF(42),
	ELSE(44), RETURNFAT(45), Ar(46), B(47), Br(48), C(49), Cr(50), D(51), Dr(52),
	E(53) , Er(54) , F(55) , Fr(56), G(57), H(58), Hr(59), DECLARATIONFAT(60);
	
	private int nonTerminalValue;

	private NonTerminalName(int value) {
		this.nonTerminalValue = value;
	}

	public int getNonTerminalValue() {
		return nonTerminalValue;
	}

}
