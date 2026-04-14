package array;

import java.util.Arrays;

/**
 * Question 37: Trapping Rain Water (LeetCode 42)
 * 
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the width 
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by 
 * array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water 
 * (blue section) are being trapped.
 * 
 * Logic (Optimal - Two Pointers Approach):
 * 1. We use two pointers, left and right.
 * 2. We keep track of left_max and right_max.
 * 3. While left < right:
 *    a. If height[left] < height[right]:
 *       - If height[left] >= left_max, update left_max.
 *       - Else, water += left_max - height[left].
 *       - Increment left.
 *    b. Else:
 *       - If height[right] >= right_max, update right_max.
 *       - Else, water += right_max - height[right].
 *       - Decrement right.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Question37 {

    /**
     * Calculates the total trapped water.
     * @param height Elevation map
     * @return Total trapped rain water
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("          Trapping Rain Water             ");
        System.out.println("==========================================\n");

        // Test Case 1: Standard Example
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        runTest(height1, "Standard Elevation Map");

        // Test Case 2: Concave/Dip shape
        int[] height2 = {4, 2, 0, 3, 2, 5};
        runTest(height2, "Dip Pattern");

        // Test Case 3: Constant height
        int[] height3 = {3, 3, 3, 3};
        runTest(height3, "Flat Surface");

        // Test Case 4: Increasing height
        int[] height4 = {1, 2, 3, 4, 5};
        runTest(height4, "Stairs (Increasing)");

        // Test Case 5: Single Wall
        int[] height5 = {5};
        runTest(height5, "Single Bar");
        
        // Test Case 6: Empty Array
        int[] height6 = {};
        runTest(height6, "Empty Input");
    }

    private static void runTest(int[] height, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Elevation Map: " + Arrays.toString(height));
        int result = trap(height);
        System.out.println("Water Trapped: " + result);
        System.out.println("------------------------------------------\n");
    }
}
