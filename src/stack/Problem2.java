package stack;

import java.util.Stack;

/**
 * Problem 2: Remove All Adjacent Duplicates In String.
 * Given a string s, repeatedly remove adjacent duplicate characters until no such duplicates exist.
 */
public class Problem2 {

    /**
     * Removes adjacent duplicates from a string using a Stack.
     * @param s The input string.
     * @return The string after removing duplicates.
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If stack not empty and top equals current char → remove
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            // Otherwise push current char
            else {
                stack.push(ch);
            }
        }

        // Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String test1 = "abbaca";
        String test2 = "azxxzy";
        String test3 = "aabbcc";

        System.out.println("Input: " + test1 + " -> Output: " + removeDuplicates(test1)); // Expected: ca
        System.out.println("Input: " + test2 + " -> Output: " + removeDuplicates(test2)); // Expected: ay
        System.out.println("Input: " + test3 + " -> Output: " + removeDuplicates(test3)); // Expected: ""
    }
}

