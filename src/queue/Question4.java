package queue;

import java.util.*;

/**
 * Problem: First non-repeating character in a stream.
 * Given a string A denoting a stream of characters. Your task is to find the first non-repeating character 
 * for each character such that it is the first non-repeating character of all the characters present 
 * in the stream until that time.
 */
public class Question4 {

    public static String solve(String A) {
        StringBuilder res = new StringBuilder();
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            
            // 1. Update frequency and add to queue
            freq[ch - 'a']++;
            q.add(ch);

            // 2. Remove characters that are repeating from the front of the queue
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // 3. The front of the queue is our current first non-repeating character
            if (q.isEmpty()) {
                res.append("#");
            } else {
                res.append(q.peek());
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String input1 = "aabc";
        System.out.println("Input: " + input1 + " -> Output: " + solve(input1)); // Expected: a#bb

        String input2 = "abcabc";
        System.out.println("Input: " + input2 + " -> Output: " + solve(input2)); // Expected: aaabc#

        String input3 = "zzxx";
        System.out.println("Input: " + input3 + " -> Output: " + solve(input3)); // Expected: z#x#
    }
}
