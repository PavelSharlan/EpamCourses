package by.bsu.gift.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by 7 on 22.05.2016.
 */
public class FileReporter implements Reporter {
    private String path;
    private static final Logger LOGGER = LogManager.getLogger(FileReporter.class);

    public FileReporter(String path) {
        this.path = path;
    }

    @Override
    public void report(String s) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            PrintStream ps = new PrintStream(fos);
            ps.println(s);
            ps.close();
            fos.close();
        } catch (IOException e) {
            LOGGER.error("Something is wrong with IO", e);
        }
    }
}
