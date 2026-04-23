package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: First non-repeating character in a stream.
 * Given a stream of characters, find the first non-repeating character 
 * from the stream for each increment of the stream.
 * 
 * Example:
 * Input: "aabccxb"
 * Output: "a -1 b b b b x"
 */
public class Question6 {

    /**
     * Finds and prints the first non-repeating character in a stream.
     * @param str The stream of characters.
     */
    public static void firstNonRepeating(String str) {
        int[] freq = new int[26]; // To track frequency of 'a'-'z'
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Step 1: Add character to frequency array and queue
            freq[ch - 'a']++;
            q.add(ch);

            // Step 2: Remove repeating characters from the front of the queue
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // Step 3: Print the result for the current stream increment
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String stream = "aabccxb";
        System.out.println("Stream: " + stream);
        System.out.print("First non-repeating characters: ");
        firstNonRepeating(stream);
        // Expected Output: a -1 b b b b x 
    }
}
