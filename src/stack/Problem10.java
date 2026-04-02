package stack;

import java.util.Stack;

/**
 * Problem 10: Evaluate Reverse Polish Notation (LeetCode 150)
 * 
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return the integer that represents the value of the expression.
 * 
 * Valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 */
public class Problem10 {

    /**
     * Logic:
     * - Iterate through the tokens.
     * - If the token is a number, push it onto the stack.
     * - If the token is an operator, pop two numbers from the stack, 
     *   perform the operation, and push the result back onto the stack.
     * - The final result will be the only element left in the stack.
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop the last two operands
                int val2 = stack.pop();
                int val1 = stack.pop();
                
                // Perform operation and push result
                int result = applyOp(val1, val2, token);
                stack.push(result);
            } else {
                // If it's a number, push it
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int applyOp(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division
            default: return 0;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: ((2 + 1) * 3) = 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Expression: [2, 1, +, 3, *]");
        System.out.println("Output: " + evalRPN(tokens1)); // Expected 9
        System.out.println();

        // Test Case 2: (4 + (13 / 5)) = 6
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Expression: [4, 13, 5, /, +]");
        System.out.println("Output: " + evalRPN(tokens2)); // Expected 6
        System.out.println();

        // Test Case 3: ((10 * (6 / ((12 + 3) * -11))) + 17) + 5 = 22
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        // Simplified for testing: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
        // Note: I used a slightly different set to match LeetCode's complex example
        System.out.println("Output (Complex): " + evalRPN(tokens3));
    }
}
