package stack;

import java.util.Stack;
import java.util.Arrays;

/**
 * Problem 8: Stock Span Problem
 * 
 * The span of a stock's price on a given day is defined as the maximum number of 
 * consecutive days (including the current day) the price has been less than or 
 * equal to its price on that day.
 */
public class Problem8 {

    /**
     * Calculates the stock span for each day.
     * Logic: Use a stack to find the index of the previous greater element.
     * If there's no previous greater element, span is current_index + 1.
     * Else, span is current_index - index_of_previous_greater_element.
     */
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through each price
        for (int i = 0; i < n; i++) {
            // Remove indices of elements that are smaller or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, current element is greater than all previous elements
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Peek the index of the nearest previous greater element
                span[i] = i - stack.peek();
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {100, 80, 60, 70, 60, 75, 85};
        int[] span1 = calculateSpan(prices1);
        System.out.println("Prices: " + Arrays.toString(prices1));
        System.out.println("Span:   " + Arrays.toString(span1));
        // Expected Span: [1, 1, 1, 2, 1, 4, 6]
        System.out.println();

        // Test Case 2
        int[] prices2 = {10, 4, 5, 90, 120, 80};
        int[] span2 = calculateSpan(prices2);
        System.out.println("Prices: " + Arrays.toString(prices2));
        System.out.println("Span:   " + Arrays.toString(span2));
        // Expected Span: [1, 1, 2, 4, 5, 1]
    }
}
