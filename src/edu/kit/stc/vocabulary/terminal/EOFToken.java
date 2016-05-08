package edu.kit.stc.vocabulary.terminal;

/**
 * Created by florian on 08.05.16.
 */
public class EOFToken extends Token {
    public EOFToken(int position) {
        super("", position);
    }

    @Override
    public String toString() {
        return "EOFToken at " + super.position;
    }
}
