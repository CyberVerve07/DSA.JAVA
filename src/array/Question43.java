package array;

import java.util.Arrays;

/**
 * Question 43: Best Time to Buy and Sell Stock (LeetCode 121)
 * 
 * Problem Statement:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock 
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * 
 * Logic:
 * 1. Maintain a variable `minPrice` initialized to a very large value.
 * 2. Maintain a variable `maxProfit` initialized to 0.
 * 3. Iterate through the array:
 *    - Update `minPrice` if the current price is lower than the current `minPrice`.
 *    - Calculate potential profit (current price - `minPrice`).
 *    - Update `maxProfit` if this potential profit is greater than the current `maxProfit`.
 * 4. Return `maxProfit`.
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the number of days.
 * - Space Complexity: O(1).
 */
public class Question43 {

    /**
     * Finds the maximum profit from buying and selling a stock.
     * @param prices an array of stock prices
     * @return the maximum profit
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   Best Time to Buy and Sell Stock Solver  ");
        System.out.println("==========================================\n");

        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        runTest(prices1, "Case 1 (Standard Profit)");

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        runTest(prices2, "Case 2 (No Profit Possible)");

        // Test Case 3
        int[] prices3 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9};
        runTest(prices3, "Case 3 (Volatile Market)");
    }

    private static void runTest(int[] prices, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Prices: " + Arrays.toString(prices));
        
        int result = maxProfit(prices);
        
        System.out.println("Max Profit: " + result);
        System.out.println("------------------------------------------\n");
    }
}
