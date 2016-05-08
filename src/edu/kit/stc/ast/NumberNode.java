package edu.kit.stc.ast;

import edu.kit.stc.vocabulary.terminal.NumberToken;

public class NumberNode extends LeafNode{
	private NumberToken number;
	
	public NumberNode(NumberToken number) {
		this.number = number;
	}
	
	@Override
	public float calculate() {
		return number.toFloat();
	}
}
