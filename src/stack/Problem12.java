package stack;

import java.util.Stack;

/**
 * Problem 12: Daily Temperatures (LeetCode 739)
 * 
 * Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days you have 
 * to wait after the ith day to get a warmer temperature. If there is no future 
 * day for which this is possible, keep answer[i] == 0 instead.
 */
public class Problem12 {

    /**
     * Logic: Use a monotonic decreasing stack to store indices of the temperatures.
     * When we encounter a warmer temperature, it means we have found the next warmer 
     * day for the temperatures at the top of the stack. We pop those indices and 
     * calculate the difference in days.
     * 
     * Time Complexity: O(n) - Each element is pushed and popped at most once.
     * Space Complexity: O(n) - The stack can hold up to n elements in the worst case.
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is greater 
            // than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // Calculate the number of days
            }
            // Push the current day's index onto the stack
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {73, 74, 75, 71, 69, 72, 76, 73},
            {30, 40, 50, 60},
            {30, 60, 90}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Temperatures: [");
            for (int j = 0; j < testCases[i].length; j++) {
                System.out.print(testCases[i][j] + (j == testCases[i].length - 1 ? "" : ", "));
            }
            System.out.println("]");

            int[] result = dailyTemperatures(testCases[i]);
            System.out.print("Answer:       [");
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + (j == result.length - 1 ? "" : ", "));
            }
            System.out.println("]\n");
        }
    }
}
