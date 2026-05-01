package stack;

import java.util.Stack;

/**
 * Problem 13: Valid Parentheses (LeetCode 20)
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 */
public class Problem13 {

    /**
     * Logic: Use a stack to keep track of opening brackets. 
     * When a closing bracket is encountered, check if it matches the top of the stack.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean isValid(String s) {
        // TODO: Implement your logic here
        return false;
    }

    public static void main(String[] args) {
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};

        for (String test : testCases) {
            System.out.println("Input: " + test + " -> Valid: " + isValid(test));
        }
    }
}
