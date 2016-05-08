package edu.kit.stc.ast;

public class MultNode extends BinaryNode{

	public MultNode(AstNode left, AstNode right) {
		super(left, right);
	}

	@Override
	public float operate(float left, float right) {
		return left*right;
	}
}
