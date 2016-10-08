package by.bsu.infhandling.parser;

import by.bsu.infhandling.composite.CompositeElement;
import by.bsu.infhandling.util.TextFileReader;

import static by.bsu.infhandling.composite.CompositeType.*;

public class TextParser {

    private CompositeElement element;

    public CompositeElement getElement(){
        return element;
    }

    public void parseText(String fileName){
        TextParserHandler textParserHandler = new TextParserHandler(TEXT);
        ParagraphParserHandler paragraphParserHandler = new ParagraphParserHandler(PARAGRAPH);
        SentenceParserHandler sentenceParserHandler = new SentenceParserHandler(SENTENCE);
        LexemeParserHandler lexemeParserHandler = new LexemeParserHandler(LEXEME);
        textParserHandler.setSuccessor(paragraphParserHandler);
        paragraphParserHandler.setSuccessor(sentenceParserHandler);
        sentenceParserHandler.setSuccessor(lexemeParserHandler);

        element = textParserHandler.chain(TextFileReader.readFile(fileName));
    }
}
