package by.bsu.infhandling.parser;

import by.bsu.infhandling.composite.CompositeElement;
import by.bsu.infhandling.composite.CompositeType;

public abstract class AbstractHandler {
    protected AbstractHandler successor;
    protected CompositeElement element;
    private CompositeType type;

    public AbstractHandler(CompositeType type){
        this.type = type;
    }

    public abstract void parse(String text);
    public CompositeElement chain(String text){
        element = new CompositeElement(type);
        parse(text);
        return element;
    }

    public void setSuccessor(AbstractHandler successor){
        this.successor = successor;
    }

}
