package edu.kit.stc.vocabulary.terminal;

public class POpenToken extends Token{

	public POpenToken(int position) {
		super("(", position);
	}

	@Override
	public String toString() {
		return "POpenToken at " + super.position + ".\n\tRaw value: " + super.rawValue;
	}
}
