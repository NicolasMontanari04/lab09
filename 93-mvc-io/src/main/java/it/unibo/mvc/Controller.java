package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    public void setString(String chars); //Set the next string to print 
    public String getNextString(); // A method for getting the next string to print
    public List<String> getList(); //A method for getting the history of the printed strings 
    public void printCurrentString();//A method that prints the current string. 
}
