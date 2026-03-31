package stack;

import java.util.Stack;

/**
 * Problem 9: Remove All Adjacent Duplicates In String (LeetCode 1047)
 * 
 * You are given a string s consisting of lowercase English letters. 
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 */
public class Problem9 {

    /**
     * Logic: Use a stack to track characters.
     * If the current character is the same as the character at the top of the stack,
     * it means we found an adjacent duplicate, so we pop the stack.
     * Otherwise, we push the current character onto the stack.
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If stack is not empty and current char matches the top
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // Remove the duplicate
            } else {
                stack.push(c); // Add to stack
            }
        }

        // Build the final string from the stack
        StringBuilder result = new StringBuilder();
        for (Character ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abbaca";
        System.out.println("Input:  " + s1);
        System.out.println("Output: " + removeDuplicates(s1)); // Expected: "ca"
        System.out.println();

        // Test Case 2
        String s2 = "azxxzy";
        System.out.println("Input:  " + s2);
        System.out.println("Output: " + removeDuplicates(s2)); // Expected: "ay"
        System.out.println();

        // Test Case 3
        String s3 = "aaaaaaaa";
        System.out.println("Input:  " + s3);
        System.out.println("Output: " + removeDuplicates(s3)); // Expected: "" (empty string)
    }
}
