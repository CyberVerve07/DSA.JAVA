package array;
class SecondLargest {

    public static int secondLargest(int[] nums) {

        if (nums.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        // If second largest doesn't exist
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{10, 5, 20, 8})); // 10
        System.out.println(secondLargest(new int[]{3, 3, 3}));     // -1
        System.out.println(secondLargest(new int[]{5, 1}));        // 1
    }
}
