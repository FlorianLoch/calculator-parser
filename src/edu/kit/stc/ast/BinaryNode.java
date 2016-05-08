package edu.kit.stc.ast;

public abstract class BinaryNode extends InnerNode{
	public BinaryNode(AstNode left, AstNode right) {
		this.children.add(left);
		this.children.add(right);
	}
	
	public AstNode getLeftChild(){
		return this.children.get(0);
	}
	
	public AstNode getRightChild(){
		return this.children.get(1);
	}
	
	@Override
	public float calculate(){
		float left = this.getLeftChild().calculate();
		float right = this.getRightChild().calculate();
		return this.operate(left, right);
	}
	
	public abstract float operate(float left, float right);
}
