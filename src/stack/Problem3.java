package stack;

import java.util.Stack;

/**
 * Problem 3: Largest Rectangle in Histogram.
 * Given an array of integers heights representing the histogram's bar height 
 * where the width of each bar is 1, find the area of the largest rectangle in the histogram.
 */
public class Problem3 {

    /**
     * Calculates the largest rectangle area using a monotonic stack.
     * @param heights Array of bar heights.
     * @return The maximum area.
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleArea(heights);
        
        System.out.println("Histogram heights: [2, 1, 5, 6, 2, 3]");
        System.out.println("Largest Rectangle Area: " + result); // Expected: 10
    }
}

