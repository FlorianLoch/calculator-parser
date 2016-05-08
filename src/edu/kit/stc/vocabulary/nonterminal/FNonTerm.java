package edu.kit.stc.vocabulary.nonterminal;

import edu.kit.stc.vocabulary.terminal.NumberToken;
import edu.kit.stc.vocabulary.terminal.PCloseToken;
import edu.kit.stc.vocabulary.terminal.POpenToken;

public class FNonTerm extends NonTerminal{
	public FNonTerm(POpenToken po, ENonTerm e, PCloseToken pc) {
		this.children.add(po);
		this.children.add(e);
		this.children.add(pc);
	}
	
	public FNonTerm(NumberToken n) {
		this.children.add(n);
	}
}
