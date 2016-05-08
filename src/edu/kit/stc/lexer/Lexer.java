package edu.kit.stc.lexer;

import edu.kit.stc.lexer.exception.EndOfFileException;
import edu.kit.stc.lexer.exception.LException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.kit.stc.vocabulary.terminal.*;

public class Lexer {
    private int position = 0;
    private String input;

    public Lexer(String input) {
        this.input = input.toLowerCase();
    }

    private char nextChar() throws EndOfFileException {
        if (this.position == this.input.length()) {
            throw new EndOfFileException(this.position);
        }

        return this.input.charAt(this.position++);
    }

    public Queue<Token> lex() throws LException {
        Queue<Token> tokens = new LinkedList<Token>();

        while (this.position < this.input.length()) {
            char c = this.nextChar();

            if (c == '(') {
                tokens.add(new POpenToken(this.position - 1));
            }
            else if (c == ')') {
                tokens.add(new PCloseToken(this.position - 1));
            }
            else if (c == '+') {
                tokens.add(new PlusToken(this.position - 1));
            }
            else if (c == '-') {
                tokens.add(new MinusToken(this.position - 1));
            }
            else if (c == '/') {
                tokens.add(new DivToken(this.position - 1));
            }
            else if (c == '*') {
                tokens.add(new MultToken(this.position - 1));
            }
            else if (isDigit(c) || c == '.') {
                NumberToken flt = this.lexFloat(c);
                tokens.add(flt);
            }
        }

        tokens.add(new EOFToken(this.position));

        return tokens;
    }

    private NumberToken lexFloat(char firstChar) throws LException {
        String lhs = "" + firstChar;
        String exp = "";
        String rhs = "";

        char type = 'f'; //just a more-or-less randomly selected default value
        int startIndex = this.position - 1;
        char c;

        //lex lhs
        try {
            while (isDigit(c = this.nextChar())) {
                lhs += c;
            }
        } catch (EndOfFileException err) {
            throw new LException(this.position, "Input ended during lexing of number token!");
        }

        if (c != '.') {
            throw new LException(this.position - 1, "Expected '.' while lexing number token. Missing!");
        }

        //lex rhs
        try {
            while (isDigit(c = this.nextChar())) {
                rhs += c;
            }
        } catch (EndOfFileException err) {
            if (lhs.length() > 0 || rhs.length() > 0) {
                String rawValue = this.input.substring(startIndex, this.position);
                return new NumberToken(rawValue, startIndex, lhs, rhs, "", type);
            }
        }

        if (rhs.length() == 0 && lhs.length() == 0) {
            throw new LException(this.position - 1, "Number doesn't neither have a right- or left-hand-side!");
        }

        //lex exponent
        if (c == 'e') {
            try {
                c = this.nextChar();
            } catch (EndOfFileException err) {
                throw new LException(this.position, "Input ended during lexing of number token's exponent!");
            }

            if (c == '+' || c == '-') {
                exp += c;
            }
            else {
                this.position--;
            }

            String expNumber = "";
            try {
                while (isDigit(c = this.nextChar())) {
                    expNumber += c;
                }
                this.position--;
            } catch (EndOfFileException err) {
                if (expNumber.length() > 0) {
                    String rawValue = this.input.substring(startIndex, this.position);
                    return new NumberToken(rawValue, startIndex, lhs, rhs, exp + expNumber, type);
                }
            }

            if (expNumber.length() == 0) {
                throw new LException(this.position, "Exponent was introduced but is empty!");
            }

            exp += expNumber;
        }
        else {
            this.position--;
        }

        //lex type
        try {
            c = nextChar();
        } catch (EndOfFileException err) {
            String rawValue = this.input.substring(startIndex, this.position);
            return new NumberToken(rawValue, startIndex, lhs, rhs, exp, type);
        }

        if (c == 'f' || c == 'l') {
            type = c;
        }
        else {
            this.position--;
        }

        String rawValue = this.input.substring(startIndex, this.position);
        return new NumberToken(rawValue, startIndex, lhs, rhs, exp, type);
    }


    private static boolean isDigit(char c) {
        return (c >= 48 && c <= 57);
    }
}
