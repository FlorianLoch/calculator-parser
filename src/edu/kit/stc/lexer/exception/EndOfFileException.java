package edu.kit.stc.lexer.exception;

/**
 * Created by florian on 08.05.16.
 */
public class EndOfFileException extends LException {
    public EndOfFileException(int position) {
        super(position, "End of file detected when trying to read next character!");
    }
}
