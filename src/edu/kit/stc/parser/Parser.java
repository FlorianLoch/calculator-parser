package edu.kit.stc.parser;

import java.util.Queue;

import edu.kit.stc.ast.AstNode;
import edu.kit.stc.ast.DivNode;
import edu.kit.stc.ast.MultNode;
import edu.kit.stc.ast.NumberNode;
import edu.kit.stc.ast.PlusNode;
import edu.kit.stc.vocabulary.terminal.DivToken;
import edu.kit.stc.vocabulary.terminal.EOFToken;
import edu.kit.stc.vocabulary.terminal.MinusToken;
import edu.kit.stc.vocabulary.terminal.MultToken;
import edu.kit.stc.vocabulary.terminal.NumberToken;
import edu.kit.stc.vocabulary.terminal.PCloseToken;
import edu.kit.stc.vocabulary.terminal.POpenToken;
import edu.kit.stc.vocabulary.terminal.PlusToken;
import edu.kit.stc.vocabulary.terminal.Token;

public class Parser {
	private Queue<Token> tokens;
	public Parser(Queue<Token> tokens) {
		this.tokens = tokens;
	}
	
	public AstNode parseE(){
		AstNode node = parseT();
		parseEA(node);
		return node;
	};
	
	public AstNode parseEA(AstNode node){
		if(expectPlus()){
			tokens.poll();
			AstNode right = parseT();
			node = new PlusNode(node, right);
			return parseEA(node);
		}
		
		if(expectMult()){
			tokens.poll();
			AstNode right = parseT();
			node = new MultNode(node, right);
			return parseEA(node);
		}			
		
		if(expectEOF()){
			tokens.poll();
			return node;
		}
		//Exception
		return node;
	}

	public AstNode parseT(){
		AstNode node = parseF();
		return parseTA(node);
	};
	
	public AstNode parseTA(AstNode node){
		if(expectMult()){
			tokens.poll();
			AstNode right = parseF();
			node = new MultNode(node, right);
			return parseTA(node);
		}
		
		if(expectDiv()){
			tokens.poll();
			AstNode right = parseF();
			node = new DivNode(node, right);
			return parseTA(node);
		}
		
		if(expectPlus() || expectMinus() || expectEOF()){
			tokens.poll();
			return node;
		}

		//Exception
		return node;
	};
	
	public AstNode parseF(){
		if(expectPOpen()){
			tokens.poll();
			AstNode node = parseE();
			if(expectPClose()){
				tokens.poll();
				return node;
			}
		}
		
		if(expectNumber()){
			NumberToken number = (NumberToken) tokens.poll();
			return new NumberNode(number);
		}	
		//Exception
		
		return null;
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
