package by.bsu.gift.main;

import by.bsu.gift.action.Finder;
import by.bsu.gift.action.GiftMaker;
import by.bsu.gift.action.JSONLoader;
import by.bsu.gift.action.WeightSorter;
import by.bsu.gift.entity.Gift;
import by.bsu.gift.entity.Sweet;
import by.bsu.gift.exception.IncorrectValueException;
import by.bsu.gift.exception.UnknownSweetException;
import by.bsu.gift.init.SweetsInitializer;
import by.bsu.gift.report.FileReporter;
import by.bsu.gift.report.Reporter;
import by.bsu.gift.store.Storage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

/**
 * Created by 7 on 18.05.2016.
 */

public class Main {
    private static final String FILE_PATH = "data\\data.json";

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Reporter reporter = new FileReporter("out.txt");
            StringBuilder sb = new StringBuilder();
            LOGGER.info("Creating storage");
            Storage storage = new Storage(SweetsInitializer.init(JSONLoader.readFromFile(FILE_PATH)));
            LOGGER.info("The storage has been created!");
            LOGGER.info("Creating gift");
            Gift gift = GiftMaker.make(storage, 5);
            LOGGER.info("The gift has been created!");
            sb.append(gift);
            LOGGER.info("Finding the summary weight of the gift");
            double weight = gift.countWeight();
            sb.append("  with weight= ").append(weight);
            LOGGER.info("Sorting sweets from the gift");
            WeightSorter.sort(gift);
            LOGGER.info("Sweets has been sorted!");
            LOGGER.info("Searching sweets in the gift");
            ArrayList<Sweet> res = Finder.find(gift, 0.005, 0.01);
            reporter.report(sb.toString());
        } catch (UnknownSweetException e) {
            LOGGER.error("Such sweet doesn't exist!", e);
        } catch (IncorrectValueException e){
            LOGGER.error("Something is wrong with value!", e);
        }
    }
}
