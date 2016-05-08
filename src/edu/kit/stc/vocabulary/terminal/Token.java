package edu.kit.stc.vocabulary.terminal;

import edu.kit.stc.vocabulary.Vocable;

public abstract class Token extends Vocable{
	public final String rawValue;
	public final int position;
	
	public Token(String rawValue, int position){
		this.rawValue = rawValue;
		this.position = position;
	}
}
