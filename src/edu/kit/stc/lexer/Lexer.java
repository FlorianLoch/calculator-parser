package edu.kit.stc.lexer;

import edu.kit.stc.lexer.token.Token;
import java.util.ArrayList;

public class Lexer {
    private int position = 0;
    private String input;

    public Lexer(String input) {
        this.input = input.toLowerCase();
    }

    private char nextChar() {
        return this.input.charAt(this.position++);
    }

    public ArrayList<Token> lex() {
        ArrayList<Token> tokens = new ArrayList<Token>();

        while (this.position < this.input.length()) {
            char c = this.nextChar();

            if (c == '(') {
                tokens.add(new ParoToken());
            }
            else if (c == ')') {
                tokens.add(new ParcToken());
            }
            else if (c == '+') {
                tokens.add(new PlusToken());
            }
            else if (c == '-') {
                tokens.add(new MinusToken());
            }
            else if (c == '/') {
                tokens.add(new DivToken());
            }
            else if (c == '*') {
                tokens.add(new MultToken());
            }
            else if (isDigit(c) || c == '.') {
                this.lexFloat();
            }
        }

    }

    static boolean isDigit(char c) {
        return (c >= 48 && c <= 57);
    }
}
