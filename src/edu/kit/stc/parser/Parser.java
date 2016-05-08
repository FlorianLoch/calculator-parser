package edu.kit.stc.parser;

import java.util.Queue;

import edu.kit.stc.lexer.Lexer;
import edu.kit.stc.vocabulary.terminal.DivToken;
import edu.kit.stc.vocabulary.terminal.MinusToken;
import edu.kit.stc.vocabulary.terminal.MultToken;
import edu.kit.stc.vocabulary.terminal.NumberToken;
import edu.kit.stc.vocabulary.terminal.PCloseToken;
import edu.kit.stc.vocabulary.terminal.POpenToken;
import edu.kit.stc.vocabulary.terminal.PlusToken;
import edu.kit.stc.vocabulary.terminal.Token;

public class Parser {
	
	Queue<Token> tokens;
	
	public Parser() {
		
	}
	
	public void parseE(){
		parseT();
		parseEA();
	};
	
	public void parseEA(){
		if(expectPlus() || expectMinus()){
			if(expectPlus()){
				
			}else{
				
			}			
			tokens.poll();
			parseT();
			parseEA();
			return;
		}
		
		if(expectEOF()){
				
			return;
		}
		//Exception
	}

	public void parseT(){
		parseF();
		parseTA();
	};
	
	public void parseTA(){};
	
	public void parseF(){
		if(expectPOpen()){
			tokens.poll();
			parseE();
			if(expectPClose()){
				tokens.poll();
				return;
			}
		}
		if(expectNumber()){
			tokens.poll();
			return;
		}	
		//Exception
	};
	
	public boolean expectPlus(){
		return tokens.element() instanceof PlusToken;
	}
	public boolean expectMinus(){
		return tokens.element() instanceof MinusToken;
	}
	public boolean expectDiv(){
		return tokens.element() instanceof DivToken;
	}
	public boolean expectMult(){
		return tokens.element() instanceof MultToken;
	}
	private boolean expectPOpen() {
		return tokens.element() instanceof POpenToken;
	}
	private boolean expectPClose() {
		return tokens.element() instanceof PCloseToken;
	}
	private boolean expectNumber() {
		return tokens.element() instanceof NumberToken;
	}
	private boolean expectEOF() {
		return tokens.element() instanceof EOFToken;
	}
}
