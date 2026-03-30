package array;

import java.util.Arrays;

/**
 * Question 35: Move All Zeroes to End
 * 
 * Problem Statement:
 * Given an integer array nums, move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * 
 * Note: You must do this in-place without making a copy of the array.
 * 
 * Example:
 * Input: nums = [0, 1, 0, 3, 12]
 * Output: [1, 3, 12, 0, 0]
 * 
 * Logic (Optimal Approach - Two Pointers):
 * 1. Maintain a pointer 'j' (lastNonZeroFoundAt) to track the position 
 *    where the next non-zero element should be placed.
 * 2. Iterate through the array with pointer 'i'.
 * 3. Whenever we find a non-zero element (nums[i] != 0), we swap it 
 *    with the element at index 'j' and increment 'j'.
 */
public class Question35 {

    /**
     * Moves all zeroes to the end of the array.
     * @param nums Input array
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0; // Pointer for the next non-zero element

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // Swap non-zero element at i with the element at j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                j++; // Increment non-zero pointer
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Move All Zeroes to End             ");
        System.out.println("==========================================\n");

        // Test Case 1: Standard Mixed Array
        int[] nums1 = {0, 1, 0, 3, 12};
        runTest(nums1, "Standard Mixed Array");

        // Test Case 2: Array with single zero
        int[] nums2 = {0};
        runTest(nums2, "Single Zero Element");

        // Test Case 3: Array with no zeroes
        int[] nums3 = {1, 2, 3, 4};
        runTest(nums3, "No Zeroes");

        // Test Case 4: All zeroes
        int[] nums4 = {0, 0, 0, 0};
        runTest(nums4, "All Zeroes");
        
        // Test Case 5: Already moved zeroes
        int[] nums5 = {1, 5, 0, 0};
        runTest(nums5, "Already Moved");
    }

    private static void runTest(int[] nums, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Input:  " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("------------------------------------------\n");
    }
}
