package edu.kit.stc.lexer.exception;

/**
 * Created by florian on 08.05.16.
 */
public class LException extends Exception {
    private int position;

    public LException(int position, String message) {
        super(message);
        this.position = position;
    }

    @Override
    public String getMessage() {
        return "Error occured during lexing at position " + this.position + ".\n" +
                "Additional information provided: " + super.getMessage();
    }
}
