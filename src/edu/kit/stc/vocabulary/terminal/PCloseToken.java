package edu.kit.stc.vocabulary.terminal;

public class PCloseToken extends Token{

	public PCloseToken(int position) {
		super(")", position);
	}

	@Override
	public String toString() {
		return "PCloseToken at " + super.position + ".\n\tRaw value: " + super.rawValue;
	}
}
