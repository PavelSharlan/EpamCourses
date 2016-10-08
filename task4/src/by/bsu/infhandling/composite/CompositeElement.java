package by.bsu.infhandling.composite;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

public class CompositeElement implements Component{
    private ArrayList<Component> content;
    private CompositeType type;

    public CompositeElement(CompositeType type) {
        this.type = type;
        content = new ArrayList<Component>();
    }

    public CompositeType getType() {
        return type;
    }

    public List<Component> getContent() {
        return Collections.unmodifiableList(content);
    }

    public void add(Component c){
        content.add(c);
    }

    public String toString(){
        String result;
        switch(type){
            case PARAGRAPH:
                result = "\n\t";
                result += takeSubComponentString();
                break;
            case SENTENCE:
                result = " ";
                result += takeSubComponentString() ;
                break;
            case LEXEME:
                result = takeSubComponentString();
                result += " ";
                break;
            default:
                result = takeSubComponentString();
        }
        return result;
    }

    private String takeSubComponentString(){
        String result = "";
        for(Component c: content){
            result += c.toString();
        }
        return result;
    }
}
