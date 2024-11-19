package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String current = null;
    private List<String> listString = new LinkedList<>();

    @Override
    public void setString(String chars) {
        if(chars.equals(null)){
            throw new NullPointerException();
        }else{
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
        if(this.current.equals(null)){
            throw new IllegalStateException();
        }else{
            listString.add(current);
        }
        System.out.println(this.current);
    }

}
