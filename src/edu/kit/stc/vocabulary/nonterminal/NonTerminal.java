package edu.kit.stc.vocabulary.nonterminal;

import java.util.List;

import edu.kit.stc.vocabulary.Vocable;

public abstract class NonTerminal extends Vocable{
	protected List<Vocable> children;
	public List<Vocable> getChildren(){
		return this.children;
	}
}
