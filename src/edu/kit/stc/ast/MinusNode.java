package edu.kit.stc.ast;

public class MinusNode extends BinaryNode{

	public MinusNode(AstNode left, AstNode right) {
		super(left, right);
	}

	@Override
	public float operate(float left, float right) {
		return left-right;
	}
}
