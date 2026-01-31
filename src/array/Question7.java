//Given an integer array nums, return the length of the shortest subarray which, if sorted, makes the entire array sorted.
//
//If the array is already sorted, return 0.
package array;
import java.util.Scanner;
public class Question7 {
        public static int findUnsortedSubarray(int[] nums) {
            int n = nums.length;

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            int left = -1, right = -1;

            // Left to right: find right boundary
            for (int i = 0; i < n; i++) {
                if (nums[i] >= max) {
                    max = nums[i];
                } else {
                    right = i;
                }
            }

            // Right to left: find left boundary
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] <= min) {
                    min = nums[i];
                } else {
                    left = i;
                }
            }

            return (left == -1) ? 0 : (right - left + 1);
        }

        public static void main(String[] args) {
            int[] nums = {2, 6, 4, 8, 10, 9, 15};
            System.out.println(findUnsortedSubarray(nums)); // Output: 5
        }
    }



