package by.bsu.parsing.main;

import by.bsu.parsing.builder.CandiesDOMBuilder;
import by.bsu.parsing.builder.CandiesSAXBuilder;
import by.bsu.parsing.builder.CandiesStAXBuilder;
import by.bsu.parsing.entity.GlazedCandy;
import by.bsu.parsing.entity.Lollipop;
import by.bsu.parsing.report.FileReporter;
import by.bsu.parsing.report.Reporter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import by.bsu.parsing.valid.XMLValidator;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 7 on 22.06.2016.
 */
public class Main {
    public static final String FILE_XML = "resources/candies.xml";
    public static final String FILE_XSD = "resources/candies.xsd";
    private static final String FILE_OUT = "out.txt";
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Program is starting!");
        XMLValidator.validate(FILE_XML, FILE_XSD);
        CandiesDOMBuilder domBuilder = new CandiesDOMBuilder();
        domBuilder.buildLollipopList(FILE_XML);
        domBuilder.buildGlazedCandiesList(FILE_XML);
        LOGGER.info("DOM-parser works correctly!");
        CandiesSAXBuilder saxBuilder = new CandiesSAXBuilder();
        saxBuilder.buildListsCandies(FILE_XML);
        LOGGER.info("SAX-parser works correctly!");
        CandiesStAXBuilder staxBuilder = new CandiesStAXBuilder();
        staxBuilder.buildListsCandies(FILE_XML);
        LOGGER.info("StAX-parser works correctly!");

        ArrayList<Lollipop> lollipops = staxBuilder.getLollipops();
        ArrayList<GlazedCandy> glazedCandies = staxBuilder.getGlazedCandies();
        Reporter reporter = new FileReporter(FILE_OUT);
        reporter.reportLollipops(lollipops);
        reporter.reportGlazedCandies(glazedCandies);
        LOGGER.info("The program has completed!");
    }
}
