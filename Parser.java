package TestFinal;
import java.util.List;



/* 
 * An instant of this class should exist In the Complier Class
b. Takes in aa list of Token object in its constructor
c. Outputs a parse tree of called functions that would recognize the input is
syntactically correct
d. REQUIRE YOU CREATE GRAMMAR RULES THAT WOULD SATISFY A TOP DOWN PARSER
e. Should be coded in the style of a recursive decent parser
f. Code should be able to handle multiple code statements
i. A valid code file should be able to have 0 or many valid statements
g. A statement should be able to be one of the following
	i. Code block
	ii. Selection Statement
	iii. Loop Statement
	iv. Assignment Statement
		1. Should be able to assign an expression to a variable
		2. Expressions should be able to have Boolean solutions
		3. Operands in expressions can be variables, real_literal, natural_literal, bool_literal, charl_literal, string_literal, function_call
		4. Expressions should allow for unary negation operator
			a. If this symbol comes after any sumbol outside of the assignment operator or the opening symbol(s) to specify 
			   the breaking order of operations it should require it to be in the symbol(s) to specify the breaking order of operations
	v. Declaration statement
		1. Variables
		2. Functions Definition
 */


/* RULES 
 * 		<program> --> <stmt>
		<program> --> <stmt> <program>
		<stmt> --> <if_stmt> | <while_stmt> | <assign_stmt> | <block_stmt>
		<block_stmt> (structure) --> ‘{‘ { <stmt> ‘;’ } ‘}’
		<if_stmt> --> ‘if’ ‘(‘ <bool_expr> ‘)’ <stmt> [ ‘else’ <stmt> ]
		 	//Need help g. iv. 2
		<bool_expr> --> <band> {'OR' <band>}
		<band> --> <beq> {'AND' <beq>}
		<beq> --> <brel> {('!=' | '==') <brel>}
		<brel> --> <bexpr> {( '<=' | '>=' | '<' | '>') <bexpr>}
		<bexpr> --> <bterm> {( '+' | '-')<bterm> }
		<bterm> <bnot> {('*' | '\' | '%') <bnot> }
		<bnot> --> [!]<bfactor>
		<bfactor> ‘id’ | ‘int_lit’  | ‘float_lit’ | ‘(‘ <expr> ‘)’| bool_lit | '(' <bexpr> ')'
		
		<while_stmt> --> ‘while’ ‘(’ <bool_expr> ’)’ <stmt> 
		<assign_stmt> --> ‘id’ ‘=’ <expr> ';'
		<expr> --> <term> { ( ‘+’ | ‘-‘ ) <term> }| <bool_expr>
		<term> --> <factor> { ( ‘*’ | ‘\’ | ‘%’ ) <factor> }
		<factor> --> ‘id’ | ‘int_lit’  | 'double' | ‘(‘ <expr> ‘)’| bool_lit 
		 //need declaration statement?//NEED HELP with function stuff
		 */
public class Parser {


static Token nexttoken; 
static Lex l;
	//NEEED TO FIX
	public Parser() {}

		int placeholder=0; 
		
	public Parser(Lex lex){ 
			 
			nexttoken=lex.lex();
			l=lex;
	} 
	public	void parse() { 
			
			program(); 
			
		}

	 void program() { 
			stmt(); 
			
			while(nexttoken.getTokenID()!=SpecialTokens.EOF) 
				stmt();
				
		}
		
		//<stmt>  <if_stmt> | <while_stmt> | <assign_stmt> | <block_stmt>
		public void stmt() { 
				//need help create
			if (nexttoken.getTokenID()==SpecialTokens.IF)	
			{
					if_stmt();
			}
			else if (nexttoken.getTokenID()==SpecialTokens.WHILE)
			{	 
					while_stmt();
			}
			else if (nexttoken.getTokenID()==SpecialTokens.ASSIGN_OP)
			{
					assign_stmt(); 
			}
			else if (nexttoken.getTokenID()==SpecialTokens.LCURLY)
			{
					block_stmt();
			}
			//default
			else
					error("ERROR inside stmt()");
			
		}	
		public void block_stmt() { 
			//<block_stmt> (structure)  ‘{‘ { <stmt> ‘;’ } ‘}’	
				if(nexttoken.getTokenID()==SpecialTokens.LCURLY) 
				{
					
					nexttoken=l.lex() ; 
					program(); 
					if(nexttoken.getTokenID()!=SpecialTokens.RCURLY) 
					{ 
						error("NEED } ");
					}
				} 
				else error("NEED { ");	
				
			}
		
			//<if_stmt>  ‘if’ ‘(‘ <bool_expr> ‘)’ <stmt> [ ‘else’ <stmt> ]	
			public void if_stmt() { 
			
				if(nexttoken.getTokenID()==SpecialTokens.IF) 
				{ 
				nexttoken=l.lex() ;
					if(nexttoken.getTokenID()==SpecialTokens.LCURLY)
					{ 
						nexttoken=l.lex() ; 
						expr();
						if(nexttoken.getTokenID()==SpecialTokens.RCURLY)
						{ 
							nexttoken=l.lex() ;
							stmt();
						}
						else
							error("NEED )");
					}
					else 
						error("NEED (");
				}
				else 
					error("NEED IF"); 	
				
			}
			//NEED HELP
			/* 
			<bool_expr> --> <band> {'OR' <band>}
			<band> --> <beq> {'AND' <beq>}
			<beq> --> <brel> {('!=' | '==') <brel>}
			<brel> --> <bexpr> {( '<=' | '>=' | '<' | '>') <bexpr>}
			<bexpr> --> <bterm> {( '+' | '-')<bterm> }
			<bterm> <bnot> {('*' | '\' | '%') <bnot> }
			<bnot> --> [!]<bfactor>
			<bfactor> ‘id’ | ‘int_lit’  | ‘float_lit’ | ‘(‘ <expr> ‘)’| bool_lit | '(' <bexpr> ')'
			
			public void bool_expr(){ 
			
			}		
			
			public void band(){ 
			
			}
			public void beq(){ 
			
			}
			public void brel(){ 
			
			}
			public void bexpr(){ 
			
			}
			public void bterm(){ 
			
			}
			public void bnot(){ 
			
			}
			public void bfactor(){ 
			
			}
			*/
			
			
			//<while_stmt>  ‘while’ ‘(’ <bool_expr> ’)’ <stmt> 
			public void while_stmt() { 
				
				if(nexttoken.getTokenID()==SpecialTokens.WHILE) 
				{ 
				nexttoken=l.lex() ;
					
					if(nexttoken.getTokenID()==SpecialTokens.LPAREN)
					{ 
						nexttoken.getTokenID(); 
						expr();
						if(nexttoken.getTokenID()==SpecialTokens.RPAREN)
						{ 
							nexttoken=l.lex() ;
							stmt();
						}
						else
							error("NEED )");
					}
					else 
						error("NEED ("); 
				}
				else 
					error("NEED WHILE"); 
			}
			
			//<assign_stmt>  ‘id’ ‘=’ <expr> ';'
			public void assign_stmt() { 
				
				if(nexttoken.getTokenID()==SpecialTokens.IDENT) 
				{
					nexttoken=l.lex();
					if(nexttoken.getTokenID()==SpecialTokens.ASSIGN_OP)
					{ 
						nexttoken=l.lex(); 
						expr(); 
						if(nexttoken.getTokenID()==SpecialTokens.SEMICOLON) 
						
							nexttoken=l.lex(); 
					
						else 
						
							error("NEED ;");
					
					}
					else 
						error("NEED =");
				}
				else 
					error("NEED VALID ID"); 
				
			}
			
			//<expr>  <term> { ( ‘+’ | ‘-‘ ) <term> }| <bool_expr>
			public void expr() { 
				
				term(); 
				while(nexttoken.getTokenID()==SpecialTokens.ADD_OP||nexttoken.getTokenID()==SpecialTokens.SUB_OP)
				{
					nexttoken=l.lex() ; 
					term(); 
				}
		
			}
			
			//<term>  <factor> { ( ‘*’ | ‘\’ | ‘%’ ) <factor> }
			public void term() { 
			
				factor(); 
				while(nexttoken.getTokenID()==SpecialTokens.MULT_OP||
						nexttoken.getTokenID()==SpecialTokens.DIV_OP||
						nexttoken.getTokenID()==SpecialTokens.MOD_OP) 
				{ 
					nexttoken=l.lex() ; 
					factor(); 
				}
				System.out.println("Exit <term>");
			}
			
			/* 
			   <factor>  ‘id’ | ‘int_lit’  | ‘double’ | ‘(‘ <expr> ‘)’ 
			   FIRST(<factor>)  rule for {id} {int_lit} {float_lit} { ‘(‘ }
			 */
			public void factor() { 
			//NEED HELP
				//get current token youre looking at 
				if (nexttoken.getTokenID()==SpecialTokens.IDENT||
					nexttoken.getTokenID()==SpecialTokens.INT_LIT||
					nexttoken.getTokenID()==SpecialTokens.DOUBLE||
					nexttoken.getTokenID()==SpecialTokens.LPAREN
					)
				{
						//get next token 
					nexttoken=l.lex() ;
				}
				//else if
				else { 
						if(nexttoken.getTokenID()==SpecialTokens.LPAREN)
						{ 
							nexttoken=l.lex() ; 
							expr(); 
							//make sure you have  “)”
							if(nexttoken.getTokenID()==SpecialTokens.RPAREN)
							{
								nexttoken=l.lex() ; 
							}	
							else
							{
								error("NEED )") ; 
							}	
						}
							//else no “(“
						error("NEED ( "); 
					}
				System.out.println("Exit <factor>");
			
			}
			
			public void error(String s) { 
				
				System.out.println("SYNTAX ERROR() "+ s);
				
				
			}
		
	
}
