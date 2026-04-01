package array;

import java.util.Arrays;

/**
 * Question 36: Find the Duplicate Number (LeetCode 287)
 * 
 * Problem Statement:
 * Given an array of integers 'nums' containing 'n + 1' integers where each integer 
 * is in the range [1, n] inclusive. There is only one repeated number in 'nums', 
 * return this repeated number.
 * 
 * Constraints:
 * 1. You must solve the problem without modifying the array 'nums'.
 * 2. You must use only constant O(1) extra space.
 * 3. Time complexity should be less than O(n^2).
 * 
 * Logic (Floyd's Cycle Finding Algorithm - Tortoise and Hare):
 * Since the numbers are in the range [1, n] and the array size is n+1, 
 * we can treat the array as a linked list where nums[i] is the pointer 
 * to the index of the next element.
 * 
 * 1. Phase 1: Detect Cycle
 *    - Use two pointers, slow and fast.
 *    - Move slow by 1 step: slow = nums[slow]
 *    - Move fast by 2 steps: fast = nums[nums[fast]]
 *    - They will eventually meet inside the cycle.
 * 
 * 2. Phase 2: Find Cycle Entrance
 *    - Reset slow to the beginning (index 0).
 *    - Move both slow and fast by 1 step.
 *    - The point where they meet is the duplicate number (entrance to the cycle).
 */
public class Question36 {

    /**
     * Finds the duplicate number in the array using Floyd's Cycle Finding Algorithm.
     * @param nums Input array of n+1 integers in range [1, n]
     * @return The duplicate number
     */
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        // Phase 1: Finding the intersection point of the two runners
        int slow = nums[0];
        int fast = nums[0];

        // Move once to ensure they aren't stuck at the start
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Phase 2: Finding the "entrance" to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Find the Duplicate Number          ");
        System.out.println("==========================================\n");

        // Test Case 1: Standard Duplicate
        int[] nums1 = {1, 3, 4, 2, 2};
        runTest(nums1, "Standard Duplicate (2)");

        // Test Case 2: Duplicate at the end
        int[] nums2 = {3, 1, 3, 4, 2};
        runTest(nums2, "Duplicate in Middle (3)");

        // Test Case 3: Smallest array
        int[] nums3 = {1, 1};
        runTest(nums3, "Smallest Array (1)");

        // Test Case 4: Multiple occurrences of the same duplicate
        int[] nums4 = {2, 2, 2, 2, 2};
        runTest(nums4, "Multiple Occurrences (2)");
        
        // Test Case 5: Large range
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        runTest(nums5, "Large Range (8)");
    }

    private static void runTest(int[] nums, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Input Array: " + Arrays.toString(nums));
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate Found: " + duplicate);
        System.out.println("------------------------------------------\n");
    }
}
