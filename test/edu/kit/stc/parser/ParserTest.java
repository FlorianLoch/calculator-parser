package edu.kit.stc.parser;

import edu.kit.stc.ast.AstNode;
import edu.kit.stc.vocabulary.terminal.EOFToken;
import edu.kit.stc.vocabulary.terminal.NumberToken;
import edu.kit.stc.vocabulary.terminal.PlusToken;
import edu.kit.stc.vocabulary.terminal.Token;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by florian on 08.05.16.
 */
public class ParserTest {

    @Test
    public void testParseE() throws Exception {
        Queue<Token> tokens = new LinkedList<Token>();
        tokens.add(new NumberToken("40.", 0, "40", "", "", 'f'));
        tokens.add(new PlusToken(1));
        tokens.add(new NumberToken("2.", 2, "2", "", "", 'f'));
        tokens.add(new EOFToken(3));

        Parser p = new Parser(tokens);
        AstNode ast = p.parseE();

        assertEquals(42, ast.calculate(), 0);
    }
}