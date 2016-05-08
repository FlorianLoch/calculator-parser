package edu.kit.stc.ast;

import java.util.List;

public abstract class InnerNode extends AstNode{
	protected List<AstNode> children;

	public List<AstNode> getChildren() {
		return children;
	}
}
