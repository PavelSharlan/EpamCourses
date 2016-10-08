package by.bsu.infhandling.interpreter;

public class NonterminalExpressionNumber extends AbstractMathExpression {
    private int number;

    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }

    public void interpret(Context c){
        c.pushValue(number);
    }
}
