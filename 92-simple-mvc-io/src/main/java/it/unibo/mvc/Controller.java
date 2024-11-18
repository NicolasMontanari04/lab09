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

    public void setFile(final File file){
        if(file.exists() && file.isFile()){
            currentFile = file;
        }else{
            throw new IllegalArgumentException("File not exist");
        }
    }

    public File getCurrentFile(){
        return currentFile;
    }

    public String getPath(){
        return currentFile.getAbsolutePath();
    }

    public void writeString(final String string){
        try (PrintStream ps = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
            ps.print(string);
        } catch (IOException e1) {
            throw new IllegalArgumentException("error print file");
        }
    }
}
