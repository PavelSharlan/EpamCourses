package by.bsu.infhandling.parser;

import by.bsu.infhandling.composite.CompositeType;
import by.bsu.infhandling.util.ParseRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParserHandler extends AbstractHandler {

    public ParagraphParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String paragraph) {
        Pattern pattern = Pattern.compile(ParseRegex.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()){
            String group = matcher.group();
            element.add(successor.chain(group));
        }
    }
}
