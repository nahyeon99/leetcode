package EvaluateReversePolishNotation;

import java.util.Set;
import java.util.Stack;

/**
 * using Stack
 */
class Solution2 {

    static Stack<Integer> stack = new Stack<>();
    static Set<String> operators = Set.of("+", "-", "*", "/");

    public static int evalRPN(String[] tokens) {

        for (String token : tokens) {
            if (operators.contains(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
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
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] token = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(token));
    }
}