package array;

import java.util.Arrays;

/**
 * Question 33: Reverse an Array
 * 
 * Problem Statement:
 * Given an array, reverse its elements in-place.
 * 
 * Logic (Hint):
 * We use two pointers: 'start' at the beginning and 'end' at the end.
 * Swap the elements at these pointers and move them towards each other
 * until they meet in the middle.
 * 
 * Complexity:
 * - Time: O(n) - We traverse half the array.
 * - Space: O(1) - No extra space used besides a few variables.
 */
public class Question33 {

    /**
     * Array ko in-place reverse karne ka function.
     * @param arr Target array
     */
    public static void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int start = 0;
        int end = arr.length - 1;

        // Start aur End pointers ko swap karte chalo jab tak wo beech mein na mil jayein
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Pointers ko move karo
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("   Array Reversal Problem       ");
        System.out.println("================================\n");

        // Test Case 1: Odd number of elements
        int[] arr1 = {1, 2, 3, 4, 5};
        testReverse(arr1, "Odd number of elements");

        // Test Case 2: Even number of elements
        int[] arr2 = {10, 20, 30, 40};
        testReverse(arr2, "Even number of elements");

        // Test Case 3: Only one element
        int[] arr3 = {100};
        testReverse(arr3, "Single element");

        // Test Case 4: Empty array
        int[] arr4 = {};
        testReverse(arr4, "Empty array");
    }

    private static void testReverse(int[] arr, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Before: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("After : " + Arrays.toString(arr));
        System.out.println("--------------------------------\n");
    }
}
