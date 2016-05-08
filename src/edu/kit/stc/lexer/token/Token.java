package edu.kit.stc.lexer.token;

public abstract class Token {
	public final String rawValue;
	public final int position;
	
	public Token(String rawValue, int position){
		this.rawValue = rawValue;
		this.position = position;
	}
}
