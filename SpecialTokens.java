package TestFinal;

public class SpecialTokens {

	/* keywords*/
	  /* 
	    i. real_literal represents fractional number == double
		ii. natural_literal represent whole numbers and 0 == int
		iii. bool_literal == boolean
		iv. char_liter represents a single ascii charater including escape character==char
	v. string_literal represents a any number of ascii charater including escape character == String
		*/	
	
	/* Token codes */
	 
	  public static final int LPAREN = 1;
	  public static final int RPAREN = 2;
	  public static final int ADD_OP = 3;
	  public static final int SUB_OP = 4;
	  public static final int MULT_OP = 5;
	  public static final int DIV_OP = 6;
	  public static final int EXPO_OP = 7;
	  public static final int IDENT = 8;
	  public static final int INT_LIT = 9;
	  public static final int ASSIGN_OP = 10;
	  public static final int MOD_OP = 11;
	  public static final int LESSTHAN_OP = 12;
	  public static final int GRTRTHAN_OP = 13;
	  public static final int GRTRTHANE_OP = 21;
	  public static final int LESSTHANE_OP = 14;
	  public static final int NEGATE = 15; 
	  public static final int LOG_AND =16; 
	  public static final int LOG_OR=17; 
	  public static final int LOG_NOT=18; 
	  public static final int LCURLY = 19;
	  public static final int RCURLY = 20;
	  public static final int SEMICOLON = 21;
	  public static final int IF = 22;
	  public static final int FOR = 23;
	  public static final int WHILE = 24;
	  public static final int INT = 25;
	  public static final int DOUBLE = 26;
	  public static final int BOOLEAN = 27;
	  public static final int CHAR = 28;
	  public static final int STRING = 29;
	  public static final int EOF = 0;
	
	
	
}
