package stack;

import java.util.Stack;

/**
 * Problem 11: Largest Rectangle in Histogram (LeetCode 84)
 * 
 * Given an array of integers heights representing the histogram's bar height 
 * where the width of each bar is 1, return the area of the largest rectangle 
 * in the histogram.
 */
public class Problem11 {

    /**
     * Logic: Use a monotonic increasing stack to store indices of heights.
     * When we encounter a height smaller than the top of the stack, it means 
     * the bar at the top cannot extend further to the right. 
     * We pop it and calculate the area with the popped height as the smallest bar.
     * 
     * Time Complexity: O(n) - Each element is pushed and popped exactly once.
     * Space Complexity: O(n) - Stack stores indices.
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use 0 as a sentinel value at the end to flush the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int height = heights[stack.pop()];
                // If stack is empty, it means the popped height was the smallest so far
                // and extends from index 0 to i.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Histogram: [2, 1, 5, 6, 2, 3]");
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights1)); // Expected: 10 (5*2)
        System.out.println();

        // Test Case 2: Sorted increasing
        int[] heights2 = {2, 4};
        System.out.println("Histogram: [2, 4]");
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights2)); // Expected: 4
        System.out.println();

        // Test Case 3: All same heights
        int[] heights3 = {2, 2, 2, 2};
        System.out.println("Histogram: [2, 2, 2, 2]");
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights3)); // Expected: 8
    }
}
