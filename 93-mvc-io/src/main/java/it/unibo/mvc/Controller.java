package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Set the next string to print.
     *
     * @param chars the string that will print
     * @throws IllegalArgumentException if the given string is null
     */
    void setString(String chars); 

    /**
     * A method for getting the next string to print.
     *
     * @return the next string to print
     */
    String getNextString(); 

    /**
     * A method for getting the history of the printed strings.
     *
     * @return all the strings in the list
     */
    List<String> getList();

    /**
     * A method that prints the current string. 
     *
     * @throws IllegalArgumentException if the current string is null
     */
    void printCurrentString(); 
}
