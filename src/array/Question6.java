package array;
//Problem: Longest Subarray With Equal 0s and 1s
//
//Statement
//You are given a binary array arr[] consisting only of 0 and 1.
//Return the length of the longest contiguous subarray that contains equal number of 0s and 1s.


import java.util.*;

public class Question6 {

    public static int longestSubarray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        map.put(0, -1); // important base case

        for (int i = 0; i < arr.length; i++) {
            prefixSum += (arr[i] == 0) ? -1 : 1;

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,0};
        System.out.println(longestSubarray(arr)); // 6
    }
}

