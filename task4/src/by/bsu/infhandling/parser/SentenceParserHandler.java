package by.bsu.infhandling.parser;

import by.bsu.infhandling.composite.CompositeElement;
import by.bsu.infhandling.composite.CompositeType;
import by.bsu.infhandling.storage.LexemeStorage;
import by.bsu.infhandling.util.ParseRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParserHandler extends AbstractHandler {
    public SentenceParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String sentence) {
        Pattern pattern = Pattern.compile(ParseRegex.LEXEME_REGEX);
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()){
            String group = matcher.group();
            element.add(successor.chain(group));
            LexemeStorage.addLexeme(group.trim());
        }
    }
}
