package edu.kit.stc.vocabulary.terminal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberToken extends Token {

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

	public float toFloat() {
		DecimalFormat formatter = (DecimalFormat) DecimalFormat.getNumberInstance();

//		char decimalSeparator = formatter.getDecimalFormatSymbols().getDecimalSeparator();
//		String expSeparator = formatter.getDecimalFormatSymbols().getExponentSeparator();
		String expValue = (this.exp.isEmpty()) ? "0" : this.exp;

		return Float.parseFloat(this.lhs + "." + this.rhs + "E" + expValue);
	}
}
