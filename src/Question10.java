public class Question10 {
    //Find second largest element without sorting
    //Second Largest Element (without sorting)
        public static void main(String[] args) {
            int[] arr = {10, 5, 20, 8};
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;
            for (int num : arr) {
                if (num > largest) {
                    secondLargest = largest;
                    largest = num;
                } else if (num > secondLargest && num != largest) {
                    secondLargest = num;
                }
            }
            System.out.println(secondLargest);
        }
    }

