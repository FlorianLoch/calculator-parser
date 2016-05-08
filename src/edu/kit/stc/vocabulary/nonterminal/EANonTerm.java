package edu.kit.stc.vocabulary.nonterminal;

import edu.kit.stc.vocabulary.terminal.MinusToken;
import edu.kit.stc.vocabulary.terminal.PlusToken;

public class EANonTerm extends NonTerminal{
	public EANonTerm(PlusToken p, TNonTerm t, EANonTerm ea){
		this.children.add(p);
		this.children.add(t);
		this.children.add(ea);
	}
	
	public EANonTerm(MinusToken m, TNonTerm t, EANonTerm ea){
		this.children.add(m);
		this.children.add(t);
		this.children.add(ea);
	}
	
	//Epsilon-Rule
	public EANonTerm(){
	}
}
