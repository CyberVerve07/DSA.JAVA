package array;

public class Question10
{
    //Print Duplicate Elements (no extra collection)
    public class Question101 {
        public static void main(String[] args) {

            int[] arr = {1, 2, 3, 2, 4, 1};

            for (int i = 0; i < arr.length; i++) {
                boolean alreadyPrinted = false;

                for (int k = 0; k < i; k++) {
                    if (arr[i] == arr[k]) {
                        alreadyPrinted = true;
                        break;
                    }
                }

                if (alreadyPrinted) continue;

                int count = 0;
                for (int j = i; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }

                if (count > 1) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

}
