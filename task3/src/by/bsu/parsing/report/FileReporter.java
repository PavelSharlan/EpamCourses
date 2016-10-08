package by.bsu.parsing.report;

import by.bsu.parsing.entity.Candy;
import by.bsu.parsing.entity.GlazedCandy;
import by.bsu.parsing.entity.Lollipop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by 7 on 22.06.2016.
 */
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

    public void reportLollipops(ArrayList<Lollipop> al) {
        for (int i = 0; i < al.size(); i++){
            ps.println(al.get(i));
        }
    }

    public void reportGlazedCandies(ArrayList<GlazedCandy> al) {
        for (int i = 0; i < al.size(); i++) {
            ps.println(al.get(i));
        }
    }
}
