package edu.kit.stc.vocabulary.terminal;

public class MinusToken extends Token{

	public MinusToken(int position) {
		super("-", position);
	}

	@Override
	public String toString() {
		return "MinusToken at " + super.position + ".\n\tRaw value: " + super.rawValue;
	}
}
