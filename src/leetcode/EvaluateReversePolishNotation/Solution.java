package leetcode.EvaluateReversePolishNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * using ArrayList
 */
class Solution {

    List<Integer> operands = new ArrayList<Integer>();
    Set<String> operators = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {

        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer op1 = operands.remove(operands.size() - 2);
                Integer op2 = operands.remove(operands.size() - 1);
                int result = 0;

                switch(token) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        result = op1 / op2;
                        break;
                }
                operands.add(result);
            } else {
                operands.add(Integer.parseInt(token));
            }
        }
        return operands.get(0);
    }
}