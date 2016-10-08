package by.bsu.infhandling.parser;

import by.bsu.infhandling.composite.CompositeType;
import by.bsu.infhandling.util.ParseRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParserHandler extends AbstractHandler {

    public TextParserHandler(CompositeType type){
        super(type);
    }

    @Override
    public void parse(String text) {
        Pattern pattern = Pattern.compile(ParseRegex.PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String group = matcher.group();
            element.add(successor.chain(group.trim()));
        }
    }
}
