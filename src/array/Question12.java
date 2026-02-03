//Given a sorted array and a target, find 1-based indices of two numbers whose sum equals target.
public class Question12 {
    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            if (sum < target) l++;
            else r--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(res[0] + ", " + res[1]); // 1, 2
    }
}