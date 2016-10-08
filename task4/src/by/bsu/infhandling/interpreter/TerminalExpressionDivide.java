package by.bsu.infhandling.interpreter;

/**
 * Created by 7 on 13.07.2016.
 */
public class TerminalExpressionDivide extends AbstractMathExpression {
    public void interpret(Context c){
        Integer right = c.popValue();
        Integer left = c.popValue();
        c.pushValue(left / right);
    }
}
