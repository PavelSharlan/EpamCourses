package by.bsu.infhandling.main;

import by.bsu.infhandling.action.LexemeSorter;
import by.bsu.infhandling.action.SymbolDeleter;
import by.bsu.infhandling.composite.CompositeElement;
import by.bsu.infhandling.parser.TextParser;
import by.bsu.infhandling.reporter.FileReporter;
import by.bsu.infhandling.reporter.Reporter;
import by.bsu.infhandling.storage.LexemeStorage;
import by.bsu.infhandling.util.FilePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        TextParser parser = new TextParser();
        LOGGER.info("Start parsing");
        parser.parseText(FilePath.INPUT_FILE);

        LOGGER.info("Text has been parsed");

        CompositeElement element = parser.getElement();

        Reporter reporterFullText = new FileReporter(FilePath.RESULT_FILE);
        reporterFullText.reportString(element.toString());

        ArrayList<String> lexemes = LexemeStorage.getLexemes();

        Reporter reporterForLexemeSorter = new FileReporter(FilePath.LEXEMES_FILE);
        reporterForLexemeSorter.reportString(LexemeSorter.getStringFromList(LexemeSorter.sortLexemesByFirstSymbol(lexemes)));

        LOGGER.info("Task №4 has done!");

        Reporter reporterForSymbolDeleter = new FileReporter(FilePath.LEXEMES_WITHOUT_SYMBOL_FILE);
        lexemes = LexemeStorage.getLexemes();
        reporterForSymbolDeleter.reportAL(SymbolDeleter.deleteSymbols(lexemes));

        LOGGER.info("Task №8 has done!");
    }
}
