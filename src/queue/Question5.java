package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Interleave the first half of the queue with the second half.
 * Given a queue of integers of even length, rearrange the elements by interleaving 
 * the first half of the queue with the second half of the queue.
 */
public class Question5 {

    /**
     * Interleaves the first half of the queue with the second half.
     * @param q The queue to be rearranged.
     */
    public static void interleave(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            System.out.println("Queue size must be even for exact interleaving.");
            return;
        }

        int n = q.size();
        int half = n / 2;

        // Step 1: Push the first half of the queue into a temporary queue
        Queue<Integer> firstHalf = new LinkedList<>();
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: Interleave the temporary queue and the remaining queue
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); // Add from first half
            q.add(q.remove());          // Add from second half (move front to rear)
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 11; i <= 20; i++) {
            q.add(i);
        }

        System.out.println("Original Queue: " + q);

        interleave(q);

        System.out.println("Interleaved Queue: " + q);
        // Expected: [11, 16, 12, 17, 13, 18, 14, 19, 15, 20]
    }
}
