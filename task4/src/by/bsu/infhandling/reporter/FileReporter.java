package by.bsu.infhandling.reporter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileReporter implements Reporter {
    private static final Logger LOGGER = LogManager.getLogger(FileReporter.class);
    private PrintStream ps;

    public FileReporter(String path){
        try {
            ps = new PrintStream(new FileOutputStream(path));
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found: " + path, e);
        }
    }

    public void reportAL(ArrayList<String> al){
        for (int i = 0; i < al.size(); i++){
            ps.println(al.get(i));
        }
    }


    public void reportString(String text){
        ps.println(text);
    }
}
