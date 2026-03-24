package stack;

import java.util.Stack;

public class Problem6 {

    /**
     * Finds the Next Greater Element for each element in the array.
     * Logic: Iterate from right to left, maintaining a stack of elements that 
     * could potentially be the NGE for upcoming elements.
     */
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traversed from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Step 1: Remove elements from stack that are smaller or equal to current element
            // because they cannot be the NGE for elements to the left of the current element.
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // Step 2: If stack is empty, there's no greater element on the right.
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Step 3: Top of stack is the next greater element.
                result[i] = stack.peek();
            }

            // Step 4: Push the current element to the stack.
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 2, 10, 8};
        int[] result1 = nextGreaterElement(arr1);
        printResult(arr1, result1);

        int[] arr2 = {3, 2, 1};
        int[] result2 = nextGreaterElement(arr2);
        printResult(arr2, result2);

        int[] arr3 = {1, 2, 3, 4, 5};
        int[] result3 = nextGreaterElement(arr3);
        printResult(arr3, result3);
    }

    private static void printResult(int[] arr, int[] res) {
        System.out.print("Input:  [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");

        System.out.print("NGE:    [");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i == res.length - 1 ? "" : ", "));
        }
        System.out.println("]\n");
    }
}
