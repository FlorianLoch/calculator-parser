package edu.kit.stc.vocabulary.terminal;

public class MultToken extends Token{

	public MultToken(int position) {
		super("*", position);
	}

	@Override
	public String toString() {
		return "MultToken at " + super.position + ".\n\tRaw value: " + super.rawValue;
	}
}
