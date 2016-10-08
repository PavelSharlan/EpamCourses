package by.bsu.infhandling.interpreter;

public class TerminalExpressionPlus extends AbstractMathExpression {
    public void interpret(Context c){
        c.pushValue(c.popValue() + c.popValue());
    }
}
