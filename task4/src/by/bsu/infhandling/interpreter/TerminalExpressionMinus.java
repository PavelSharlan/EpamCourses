package by.bsu.infhandling.interpreter;

public class TerminalExpressionMinus extends AbstractMathExpression {
    public void interpret(Context c){
        Integer right = c.popValue();
        Integer left = c.popValue();
        c.pushValue(left - right);
    }
}
