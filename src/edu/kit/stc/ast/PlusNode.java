package edu.kit.stc.ast;

public class PlusNode extends BinaryNode{

	public PlusNode(AstNode left, AstNode right) {
		super(left, right);
	}

	@Override
	public float operate(float left, float right) {
		return left+right;
	}

}
