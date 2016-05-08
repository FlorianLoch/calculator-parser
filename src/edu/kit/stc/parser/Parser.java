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
		return parseEA(node);
	};
	
	public AstNode parseEA(AstNode node){
		if(expect(PlusToken.class)){
			tokens.poll();
			AstNode right = parseT();
			node = new PlusNode(node, right);
			return parseEA(node);
		}
		
		if(expect(MultToken.class)){
			tokens.poll();
			AstNode right = parseT();
			node = new MultNode(node, right);
			return parseEA(node);
		}			
		
		if(expect(EOFToken.class)){
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
		if(expect(MultToken.class)){
			tokens.poll();
			AstNode right = parseF();
			node = new MultNode(node, right);
			return parseTA(node);
		}
		
		if(expect(DivToken.class)){
			tokens.poll();
			AstNode right = parseF();
			node = new DivNode(node, right);
			return parseTA(node);
		}
		
		if(expect(PlusToken.class) || expect(MinusToken.class) || expect(EOFToken.class)){
//			tokens.poll();
			return node;
		}

		//Exception
		return node;
	};
	
	public AstNode parseF(){
		if(expect(POpenToken.class)){
			tokens.poll();
			AstNode node = parseE();
			if(expect(PCloseToken.class)){
				tokens.poll();
				return node;
			}
		}
		
		if(expect(NumberToken.class)){
			NumberToken number = (NumberToken) tokens.poll();
			return new NumberNode(number);
		}	
		//Exception
		
		return null;
	};
	
	public boolean expect(Class c){
		return c.isInstance(tokens.element());
	}
}
