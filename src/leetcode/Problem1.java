package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * LeetCode 1: Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class Problem1 {

    /**
     * Logic:
     * - Use a HashMap to store the value and its index as we iterate.
     * - For each number, check if (target - num) exists in the map.
     * - If yes, we found the pair. Return their indices.
     * - If no, add the current number and its index to the map.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Nums: " + Arrays.toString(nums) + ", Target: " + target);
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result)); // Expected: [0, 1]
    }
}
