public class Question11 {
    //Same Index Sum of Two Arrays
    //
    //arr1 = {1, 2, 3}
    //arr2 = {4, 5, 6}
    //Output: {5, 7, 9}

        public static void main(String[] args) {

            int[] arr1 = {1, 2, 3};
            int[] arr2 = {4, 5, 6};

            int[] result = new int[arr1.length];

            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] + arr2[i];
            }

            for (int x : result) {
                System.out.print(x + " ");

            }}}