package array;

import java.util.Arrays;

/**
 * Question 34: Kadane's Algorithm (Maximum Subarray Sum)
 * 
 * Problem Statement:
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * 
 * Example:
 * Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: [4, -1, 2, 1] has the largest sum = 6.
 * 
 * Logic:
 * We iterate through the array and maintain:
 * 1. currentSum: Sum of the current contiguous subarray.
 * 2. maxSum: Maximum sum found so far.
 * 
 * If currentSum becomes less than the current element, we start a new subarray 
 * from the current element.
 */
public class Question34 {

    /**
     * Calculates the maximum subarray sum using Kadane's Algorithm.
     * @param nums Input array
     * @return Maximum sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either continue the current subarray or start a new one from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   Kadane's Algorithm (Max Subarray Sum)  ");
        System.out.println("==========================================\n");

        // Test Case 1: Mixed numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        runTest(nums1, "Standard Mixed Array");

        // Test Case 2: All negative numbers
        int[] nums2 = {-1, -2, -3, -4};
        runTest(nums2, "All Negative Numbers");

        // Test Case 3: All positive numbers
        int[] nums3 = {5, 4, 1, 7, 8};
        runTest(nums3, "All Positive Numbers");

        // Test Case 4: Single element
        int[] nums4 = {10};
        runTest(nums4, "Single Element");
    }

    private static void runTest(int[] nums, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Input: " + Arrays.toString(nums));
        int result = maxSubArray(nums);
        System.out.println("Max Subarray Sum: " + result);
        System.out.println("------------------------------------------\n");
    }
}
