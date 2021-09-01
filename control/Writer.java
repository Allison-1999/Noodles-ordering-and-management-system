package control;

import java.io.*;

/**
 *  Class Name: Writer.java
 *  Intro: A abstract control class to save info.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public abstract class Writer {
    private File file;
    private FileWriter fwriter;
    private BufferedWriter Bfwriter;

    /**
     * Method Name: writer()
     * @param filepath file path
     * @return BufferedWriter type
     * @throws IOException throws exceptions
     */
    public BufferedWriter writer(String filepath) throws IOException{
        file = new File(filepath);
        fwriter = new FileWriter(file);
        Bfwriter = new BufferedWriter(fwriter);
        return Bfwriter;
    }

    /**
     * Method Name: close()
     * @throws IOException throws exceptions
     */
    public void close() throws IOException {
        Bfwriter.flush();
        Bfwriter.close();
        fwriter.close();
    }
}
