package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile = new File(System.getProperty("user.home"), "output.txt");

    /**
     * Set the new file.
     *
     * @param file 
     * @throws IllegalArgumentException if the given file is null
     */
    public void setFile(final File file) {
        if (file.exists() && file.isFile()) {
            currentFile = file;
        } else {
            throw new IllegalArgumentException("File not exist");
        }
    }

    /**
     * A method for getting the current file.
     *
     * @return the file
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * A method for getting the current file path.
     *
     * @return the file path
     */
    public String getCurrentPath() {
        return currentFile.getAbsolutePath();
    }

    /**
     * write the string in the file.
     *
     * @param string to write in the file 
     * @throws IOException if the file open fail
     */
    public void writeString(final String string) throws IOException {
        try (PrintStream ps = new PrintStream(getCurrentPath(), StandardCharsets.UTF_8)) {
            ps.print(string);
        } 
    }
}
