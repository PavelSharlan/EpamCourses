package by.bsu.infhandling.interpreter;

import by.bsu.infhandling.util.ParseRegex;

import java.util.HashMap;
import java.util.Stack;

public class Translator {
    public static String toReversePolishNotation(String expression){
        HashMap<String, Integer> priorityMap = new HashMap<String, Integer>();
        priorityMap.put("(", 1);
        priorityMap.put("+", 2);
        priorityMap.put("-", 2);
        priorityMap.put("*", 3);
        priorityMap.put("/", 3);
        priorityMap.put("#", 4);
        priorityMap.put("%", 4);
        priorityMap.put("^", 4);
        StringBuilder result = new StringBuilder();
        Stack<String> functions = new Stack<String>();

        expression = expression.replaceAll(ParseRegex.REGEX_INC, "#");
        expression = expression.replaceAll(ParseRegex.REGEX_DEC, "%");
        expression = expression.replaceAll(ParseRegex.REGEX_UN, "^");

        String operands[] = expression.split(ParseRegex.REGEX);
        for (int i = 0; i < operands.length; i++){
            if (isNumber(operands[i])){
                result.append(operands[i] + " ");
            } else {
                if (functions.empty() || operands[i].equals("(")){
                    functions.push(operands[i]);
                }else if(operands[i].equals(")")){
                    while (!functions.peek().equals("(")){
                        result.append(functions.pop() + " ");
                    }
                    functions.pop();
                } else {
                    if (priorityMap.get(operands[i]) > priorityMap.get(functions.peek())){
                        functions.push(operands[i]);
                    } else {
                        while (priorityMap.get(operands[i]) <= priorityMap.get(functions.peek())){
                            result.append(functions.pop() + " ");
                            if(functions.empty()){
                                break;
                            }
                        }
                        functions.push(operands[i]);
                    }
                }
            }
        }
        while (!functions.empty()){
            result.append(functions.pop());
            result.append(" ");
        }
        return result.toString();
    }

    private static boolean isNumber(String s){
        boolean flag;
        try{
            int res = Integer.parseInt(s);
            flag = true;
        } catch(NumberFormatException e){
            flag = false;
        }
        return flag;
    }
}
