package edu.kit.stc.vocabulary.nonterminal;

public class ENonTerm extends NonTerminal{
	public ENonTerm(TNonTerm t, EANonTerm ea){
		this.children.add(t);
		this.children.add(ea);
	}
}
