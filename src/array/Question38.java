package array;

import java.util.Arrays;

/**
 * Question 38: Majority Element (LeetCode 169)
 * 
 * Problem Statement:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Logic (Boyer-Moore Voting Algorithm):
 * 1. We maintain a 'candidate' and a 'count'.
 * 2. When count is 0, we pick the current element as the candidate.
 * 3. If current element is candidate, increment count.
 * 4. Else, decrement count.
 * 5. Since majority element exists more than n/2 times, it will remain
 *    as candidate at the end.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Question38 {

    /**
     * Finds the majority element using Boyer-Moore Voting Algorithm.
     * @param nums input array
     * @return majority element
     */
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("           Majority Element               ");
        System.out.println("==========================================\n");

        // Test Case 1
        int[] nums1 = {3, 2, 3};
        runTest(nums1);

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        runTest(nums2);

        // Test Case 3
        int[] nums3 = {1};
        runTest(nums3);

        // Test Case 4
        int[] nums4 = {6, 5, 5};
        runTest(nums4);
    }

    private static void runTest(int[] nums) {
        System.out.println("Input Array: " + Arrays.toString(nums));
        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);
        System.out.println("------------------------------------------\n");
    }
}
