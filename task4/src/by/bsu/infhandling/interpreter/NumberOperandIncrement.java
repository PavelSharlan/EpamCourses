package by.bsu.infhandling.interpreter;

public class NumberOperandIncrement extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        Integer value = c.popValue();
        value = value + 1;
        c.pushValue(value);
    }
}
