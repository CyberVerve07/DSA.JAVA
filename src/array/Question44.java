package array;

import java.util.Arrays;

/**
 * Question 44: Plus One (LeetCode 66)
 * 
 * Problem Statement:
 * You are given a large integer represented as an integer array digits, 
 * where each digits[i] is the ith digit of the integer. 
 * The digits are ordered from most significant to least significant in left-to-right order. 
 * The large integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * 
 * Example 2:
 * Input: digits = [9,9,9]
 * Output: [1,0,0,0]
 * 
 * Logic:
 * 1. Start from the last digit (least significant).
 * 2. If the digit is less than 9, just increment it and return the array.
 * 3. If the digit is 9, it becomes 0, and we continue to the next digit (carry).
 * 4. If all digits were 9, we reach the end of the loop.
 * 5. In that case, create a new array of size n+1, set the first element to 1, and return it.
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the number of digits.
 * - Space Complexity: O(n) in the worst case (when all digits are 9), otherwise O(1).
 */
public class Question44 {

    /**
     * Increments the large integer represented by the digits array by one.
     * @param digits the array representing the integer
     * @return the resulting array
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0 (carry over to next iteration)
            digits[i] = 0;
        }
        
        // If we are here, it means all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        // Rest of the elements are already initialized to 0 by Java
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("            Plus One Solver               ");
        System.out.println("==========================================\n");

        // Test Case 1: Standard case
        int[] digits1 = {1, 2, 3};
        runTest(digits1, "Case 1 (Standard)");

        // Test Case 2: Carry within array
        int[] digits2 = {1, 2, 9};
        runTest(digits2, "Case 2 (Carry within)");

        // Test Case 3: All nines (Array size grows)
        int[] digits3 = {9, 9, 9};
        runTest(digits3, "Case 3 (All Nines)");

        // Test Case 4: Single digit 9
        int[] digits4 = {9};
        runTest(digits4, "Case 4 (Single Nine)");
    }

    private static void runTest(int[] digits, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Input : " + Arrays.toString(digits));
        
        int[] result = plusOne(digits.clone()); // Use clone to preserve input for display
        
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("------------------------------------------\n");
    }
}
