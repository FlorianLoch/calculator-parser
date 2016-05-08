package edu.kit.stc.vocabulary.terminal;

public class PlusToken extends Token {

	public PlusToken(int position) {
		super("+", position);	
	}

	@Override
	public String toString() {
		return "PlusToken at " + super.position + ".\n\tRaw value: " + super.rawValue;
	}
}
