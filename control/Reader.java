package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  Class Name: Reader.java
 *  Intro: A abstract control class to fill in info.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public abstract class Reader{
    private File file;
    private FileReader freader;
    private BufferedReader Bfreader;

    /**
     * Method Name: reader()
     * @param filepath file path
     * @return BufferedReader type
     * @throws IOException throws exceptions
     */
    public BufferedReader reader(String filepath) throws IOException{
        file = new File(filepath);
        freader = new FileReader(file);
        Bfreader = new BufferedReader(freader);
        return Bfreader;
    }

    /**
     * Method Name: close()
     * @throws IOException throws exceptions
     */
    public void close() throws IOException {
        Bfreader.close();
        freader.close();
    }
}
