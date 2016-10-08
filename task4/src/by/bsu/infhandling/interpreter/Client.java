package by.bsu.infhandling.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private ArrayList<AbstractMathExpression> listExpression;
    public Client(String expression){
        listExpression = new ArrayList<AbstractMathExpression>();
        parse(expression);
    }
    private void parse(String expression){
        String lexemes[] = expression.split(" ");
        for (int i = 0; i < lexemes.length; i++){
            char tmp = lexemes[i].charAt(0);
            switch (tmp){
                case '+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                case '#':
                    listExpression.add(new NumberOperandIncrement());
                    break;
                case '%':
                    listExpression.add(new NumberOperandDecrement());
                    break;
                case '^':
                    listExpression.add(new NumberOperandUnaryMinus());
                    break;
                default:
                    Scanner sc = new Scanner(lexemes[i]);
                    if (sc.hasNextInt()){
                        listExpression.add(new NonterminalExpressionNumber(sc.nextInt()));
                    }
            }
        }
    }
    public Number calculate(){
        Context context = new Context();
        for (AbstractMathExpression terminal: listExpression){
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
