package stack;

import java.util.Stack;

/**
 * Problem 4: Reverse a String using a Stack.
 */
public class Problem4 {

    /**
     * Reverses a string using the LIFO property of a Stack.
     * @param str The string to be reversed.
     * @return The reversed string.
     */
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        // Step 1: Push characters into stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Step 2: Pop characters to reverse string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String output = reverseString(input);

        System.out.println("Original: " + input);
        System.out.println("Reversed: " + output);
        
        // Additional Test
        String input2 = "antigravity";
        System.out.println("Original: " + input2);
        System.out.println("Reversed: " + reverseString(input2));
    }
}

