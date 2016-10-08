package by.bsu.infhandling.composite;

import by.bsu.infhandling.interpreter.Client;
import by.bsu.infhandling.interpreter.Translator;

public class Leaf implements Component {
    private String content;
    private LeafType type;

    public Leaf(String content, LeafType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public LeafType getType() {
        return type;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String toString(){
        String result = "";
        switch (type){
            case WORD:
                result = getContent();
                break;
            case PUNCTUATION_MARK:
                result = getContent();
                break;
            case MATH_EXPRESSION:
                Client interpreter = new Client(Translator.toReversePolishNotation(getContent()));
                result = interpreter.calculate().toString();
                break;
        }
        return result;
    }
}
