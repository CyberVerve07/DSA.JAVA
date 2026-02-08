//Problem
//
//You are building a search system.
//Different data structures search differently, but the interface is same.
//
//Base class: Search
//
//Derived classes:
//
//LinearSearch
//
//BinarySearch
abstract class Search {
    abstract int search(int[] arr, int target);
}

class LinearSearch extends Search {
    @Override
    int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}

class BinarySearch extends Search {
    @Override
    int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Search s = new BinarySearch(); // runtime decision
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(s.search(arr, 7));
    }
}
