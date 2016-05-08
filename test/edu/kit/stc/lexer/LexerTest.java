package edu.kit.stc.lexer;


import edu.kit.stc.vocabulary.terminal.Token;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by florian on 08.05.16.
 */
public class LexerTest {
    @org.junit.Test
    public void testLex() throws Exception {
        final String SAMPLE_INPUT = "abc(56.23e45L+42.)/";

        Lexer lxr = new Lexer(SAMPLE_INPUT);

        ArrayList<Token> tokens = lxr.lex();

        for (Token t : tokens) {
            System.out.println(t.toString());
        }
    }
}