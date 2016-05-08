package edu.kit.stc.vocabulary.nonterminal;

public class TNonTerm extends NonTerminal{
	
	public TNonTerm(FNonTerm f, TANonTerm ta){
		this.children.add(f);
		this.children.add(ta);
	}
}
