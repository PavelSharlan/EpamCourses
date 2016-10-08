package by.bsu.infhandling.parser;

import by.bsu.infhandling.composite.CompositeType;
import by.bsu.infhandling.composite.Leaf;
import by.bsu.infhandling.composite.LeafType;
import by.bsu.infhandling.util.ParseRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParserHandler extends AbstractHandler {

    public LexemeParserHandler(CompositeType type) {
        super(type);
    }

    public void parse(String lexeme){
        Pattern patternWordOrFormula = Pattern.compile(ParseRegex.FORMULA_OR_WORD_REGEX);
        Pattern patternWord = Pattern.compile(ParseRegex.WORD_REGEX);
        Pattern patternFormula = Pattern.compile(ParseRegex.FORMULA_REGEX);
        Pattern patternPunctuation = Pattern.compile(ParseRegex.PUNCTUATION_REGEX);
        Matcher matcherWordOrFormula = patternWordOrFormula.matcher(lexeme);
        while (matcherWordOrFormula.find()){
            String group = matcherWordOrFormula.group();
            Matcher matcherWord = patternWord.matcher(group);
            Matcher matcherFormula = patternFormula.matcher(group);
            Leaf leaf;
            String tmp;
            if (matcherWord.find()){
                tmp = matcherWord.group();
                leaf = new Leaf(tmp, LeafType.WORD);
                element.add(leaf);
                break;
            }
            if(matcherFormula.find()){
                tmp = matcherFormula.group();
                leaf = new Leaf(tmp, LeafType.MATH_EXPRESSION);
                element.add(leaf);
                break;
            }
        }
        Matcher matcherPunctuation = patternPunctuation.matcher(lexeme);
        if (matcherPunctuation.find()){
            String group = matcherPunctuation.group();
            Leaf leafPunctuation = new Leaf(group, LeafType.PUNCTUATION_MARK);
            element.add(leafPunctuation);
        }
    }
}
