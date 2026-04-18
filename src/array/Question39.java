package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question 39: Majority Element II (LeetCode 229)
 * 
 * Problem Statement:
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 * 
 * Example:
 * Input: nums = [3,2,3]
 * Output: [3]
 * 
 * Logic (Extended Boyer-Moore Voting Algorithm):
 * 1. Since at most two elements can appear more than n/3 times, we maintain two potential
 *    candidates and their respective counts.
 * 2. If current element equals candidate1, increment count1.
 * 3. Else if current element equals candidate2, increment count2.
 * 4. Else if count1 is 0, set candidate1 to current element and count1 to 1.
 * 5. Else if count2 is 0, set candidate2 to current element and count2 to 1.
 * 6. Otherwise, decrement both count1 and count2.
 * 7. Verification: After one pass, we count actual occurrences of candidate1 and candidate2
 *    to ensure they truly appear more than n/3 times.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Question39 {

    /**
     * Finds all elements that appear more than n/3 times.
     * @param nums input array
     * @return list of majority elements
     */
    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Stage 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Stage 2: Verification
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("           Majority Element II            ");
        System.out.println("==========================================\n");

        // Test Case 1
        int[] nums1 = {3, 2, 3};
        runTest(nums1); // Expected: [3]

        // Test Case 2
        int[] nums2 = {1};
        runTest(nums2); // Expected: [1]

        // Test Case 3
        int[] nums3 = {1, 2};
        runTest(nums3); // Expected: [1, 2]

        // Test Case 4
        int[] nums4 = {1, 1, 1, 3, 3, 2, 2, 2};
        runTest(nums4); // Expected: [1, 2]

        // Test Case 5
        int[] nums5 = {2, 1, 1, 3, 2, 4, 1, 4, 3, 3};
        runTest(nums5); // Expected: [] (No element > 10/3=3)
    }

    private static void runTest(int[] nums) {
        System.out.println("Input Array: " + Arrays.toString(nums));
        List<Integer> result = majorityElement(nums);
        System.out.println("Majority Element(s): " + result);
        System.out.println("------------------------------------------\n");
    }
}
