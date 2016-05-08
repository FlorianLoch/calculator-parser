package edu.kit.stc.vocabulary.terminal;

public class DivToken extends Token{

	public DivToken(int position) {
		super("/", position);
	}

	@Override
	public String toString() {
		return "DivToken at " + super.position + ".\n\tRaw value: " + super.rawValue;
	}
}
