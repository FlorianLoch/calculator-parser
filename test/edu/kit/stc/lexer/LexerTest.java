package edu.kit.stc.lexer;


import edu.kit.stc.lexer.exception.LException;
import edu.kit.stc.vocabulary.terminal.NumberToken;
import edu.kit.stc.vocabulary.terminal.Token;

import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by florian on 08.05.16.
 */
public class LexerTest {
    @org.junit.Test
    public void simpleArithOperands() throws Exception {
        final String SAMPLE_INPUT = "-+==*/";

        Lexer lxr = new Lexer(SAMPLE_INPUT);

        Queue<Token> tokens = lxr.lex();

        for (Token t : tokens) {
            System.out.println(t.toString());
        }
    }

    @org.junit.Test(expected = LException.class)
    public void faultyFloat() throws Exception {
        final String SAMPLE_INPUT = "42";

        Lexer lxr = new Lexer(SAMPLE_INPUT);

        lxr.lex();
    }

    @org.junit.Test
    public void floatWithNachkommaanteil() throws Exception {
        final String SAMPLE_INPUT = "42.42l";

        Lexer lxr = new Lexer(SAMPLE_INPUT);

        Queue<Token> tokens = lxr.lex();

        for (Token t : tokens) {
            System.out.println(t.toString());
        }
    }

    @org.junit.Test
    public void complexFloatWithExponent() throws Exception {
        final String SAMPLE_INPUT = "42.41e-14L";

        Lexer lxr = new Lexer(SAMPLE_INPUT);

        Queue<Token> tokens = lxr.lex();

        for (Token t : tokens) {
            System.out.println(t.toString());
            if (t instanceof NumberToken) {
                System.out.println("\tValue: " + ((NumberToken) t).toFloat());
            }
        }
    }
}