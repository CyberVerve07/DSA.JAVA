package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 42: Contains Duplicate (LeetCode 217)
 * 
 * Problem Statement:
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Logic:
 * 1. Use a HashSet to store elements we have already seen.
 * 2. Iterate through the array.
 * 3. For each element, check if it exists in the set.
 *    - If yes, we found a duplicate, return true.
 *    - If no, add the element to the set.
 * 4. If we finish the loop without finding duplicates, return false.
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the number of elements in the array.
 * - Space Complexity: O(n) in the worst case if all elements are distinct.
 */
public class Question42 {

    /**
     * Checks if the array contains any duplicates.
     * @param nums the input array
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        // TODO: Implement the logic here
        return false;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("        Contains Duplicate Solver         ");
        System.out.println("==========================================\n");

        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        runTest(nums1, "Case 1 (Duplicate exists)");

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        runTest(nums2, "Case 2 (No duplicates)");

        // Test Case 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        runTest(nums3, "Case 3 (Multiple duplicates)");
    }

    private static void runTest(int[] nums, String testName) {
        System.out.println("Test: " + testName);
        System.out.print("Array: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + (i == nums.length - 1 ? "" : ", "));
        }
        System.out.println("]");
        
        boolean result = containsDuplicate(nums);
        
        System.out.println("Result: " + result);
        System.out.println("------------------------------------------\n");
    }
}
