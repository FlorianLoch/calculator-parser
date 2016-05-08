package edu.kit.stc.ast;

import java.util.ArrayList;
import java.util.List;

public abstract class InnerNode extends AstNode{
	protected List<AstNode> children = new ArrayList<AstNode>();

	public List<AstNode> getChildren() {
		return children;
	}
}
