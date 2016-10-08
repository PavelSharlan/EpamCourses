package by.bsu.infhandling.util;


public class ParseRegex {
    public static final String PARAGRAPH_REGEX = "\\t[^\\t]+";
    public static final String SENTENCE_REGEX = "([^\\.\\?!]+[\\.\\?!]+)";
    public static final String LEXEME_REGEX = "([^(\\s)]*[()A-Za-zА-Яа-я0-9-+*\\/,\\.!\\?]*(\\s*))";
    public static final String FORMULA_OR_WORD_REGEX = "([А-Яа-яA-Za-z0-9()+\\-\\*\\/]+)";
    public static final String WORD_REGEX = "([А-Яа-яA-Za-z]+-[А-Яа-яA-Za-z]+)|([А-Яа-яA-Za-z]+)";
    public static final String FORMULA_REGEX = "([^a-zA-Zа-яА-Я\\-\\t ,?\\.]+[0-9\\/+\\-*()]*)";
    public static final String PUNCTUATION_REGEX = "([\\.,:\\?!\n]+)";

    public static final String REGEX_INC = "((?<=\\d)\\+{2})|(\\+{2}(?=\\d))";
    public static final String REGEX_DEC = "((?<=\\d)\\-{2})|(\\-{2}(?=\\d))";
    public static final String REGEX_UN = "((?<=^)\\-|(?<=\\()\\-)";
    public static final String REGEX = "(?<=[+\\-\\/*()#%^])|(?=[+\\-\\/*()#%^])";
}
