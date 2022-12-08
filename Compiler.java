package TestFinal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import TestFinal.Main;
public class Compiler {
	
	//Has a method that takes in an INPUT FILE and converts it to one input str NEED HELP
	
	Compiler(String file){ 
		//convert file into a string NEED HELp			 
		//pass file string into lex 
		Lex lex= new Lex(file); 
	
	//	Parser syntax = new Parser(lex); 
	//	syntax.parse(); 
		if(lex.lex().getTokenID()==SpecialTokens.EOF) { 
			System.out.println("parse works: PLEASE GIVE ME AN A :)"); 
		}
		else 
			System.out.println("parse doeesn't work: nvmd"); 
	}
	
}
