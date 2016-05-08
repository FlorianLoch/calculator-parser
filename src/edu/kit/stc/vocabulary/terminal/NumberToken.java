package edu.kit.stc.vocabulary.terminal;

public class NumberToken extends Token{

	public final String lhs;
	public final String rhs;
	public final String exp;
	public final char type;

	public NumberToken(String rawValue, int position, String lhs, String rhs, String exp, char type) {
		super(rawValue, position);
		this.lhs = lhs;
		this.rhs = rhs;
		this.exp = exp;
		this.type = type;
	}

	@Override
	public String toString() {
		return "NumberToken at " + super.position + ".\n\tRaw value: " + super.rawValue + "\n\tLHS: " + this.lhs + ", RHS: " + this.rhs + ", Exp: " + this.exp + ", Type: " + this.type;
	}
}
