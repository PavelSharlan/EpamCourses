package by.bsu.infhandling.interpreter;

import java.util.ArrayDeque;

public class Context{
    private ArrayDeque<Integer> contextValues = new ArrayDeque<Integer>();

    public Integer popValue(){
        return contextValues.pop();
    }

    public void pushValue(Integer value){
        contextValues.push(value);
    }
}
