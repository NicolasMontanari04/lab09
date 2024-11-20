package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String current;
    private final List<String> listString = new LinkedList<>();

    @Override
    public void setString(final String chars) {
        if (chars == null) {
            throw new IllegalArgumentException();
        } else {
            this.current = chars;
        }
    }

    @Override
    public String getNextString() {
        return this.current;
    }

    @Override
    public List<String> getList() {
        return List.copyOf(listString);
    }

    @Override
    public void printCurrentString() {
        if (this.current == null) {
            throw new IllegalStateException();
        } else {
            listString.add(current);
        }
        System.out.println(this.current); // NOPMD: allowed as this is just an exercise
    }
}
