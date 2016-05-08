package edu.kit.stc.vocabulary.nonterminal;

import edu.kit.stc.vocabulary.terminal.DivToken;
import edu.kit.stc.vocabulary.terminal.MultToken;

public class TANonTerm extends NonTerminal{
	public TANonTerm(MultToken m, FNonTerm f, TANonTerm ta) {
		this.children.add(m);
		this.children.add(f);
		this.children.add(ta);
	}
	
	public TANonTerm(DivToken d, FNonTerm f, TANonTerm ta) {
		this.children.add(d);
		this.children.add(f);
		this.children.add(ta);
	}
	
	//Epsilon-Rule
	public TANonTerm(){}
}
