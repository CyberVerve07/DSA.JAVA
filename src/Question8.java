//Given an integer array nums, determine whether the array can be made sorted in non-decreasing order by reversing exactly one continuous subarray.
//
//You are allowed to reverse only once
//
//If already sorted → return true
//
//No sorting allowed
package array;
public class Question8 {

    public static boolean canBeSorted(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i + 1 < n && nums[i] <= nums[i + 1]) {
            i++;
        }

        // Already sorted
        if (i == n - 1) return true;

        int j = i + 1;
        while (j + 1 < n && nums[j] >= nums[j + 1]) {
            j++;
        }

        // Check left boundary
        if (i > 0 && nums[j] < nums[i - 1]) return false;

        // Check right boundary
        if (j < n - 1 && nums[i] > nums[j + 1]) return false;

        // Check remaining array
        for (int k = j + 1; k + 1 < n; k++) {
            if (nums[k] > nums[k + 1]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 5, 4, 3, 7};
        System.out.println(canBeSorted(nums)); // true
    }
}
