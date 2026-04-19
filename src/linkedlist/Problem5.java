package linkedlist;

/**
 * Problem 5: Remove Nth Node From End of List (LeetCode 19)
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Problem5 {

    /**
     * Logic: Two-Pointer Approach
     * - Use two pointers, fast and slow, starting at a dummy node.
     * - Move fast pointer n + 1 steps forward.
     * - Then, move both pointers until fast reaches the end.
     * - The slow pointer will then be just before the node to be removed.
     * - Update slow.next to skip the nth node.
     * 
     * @param head Head of the linked list
     * @param n position from the end
     * @return The head of the modified list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node simplifies cases where the head needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n + 1 steps ahead so that there is a gap of n nodes between slow and fast
        for (int i = 0; i <= n; i++) {
            if (fast == null) return head; // n is larger than list length
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from end
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List: 1 -> 2 -> 3 -> 4 -> 5");
        
        int n = 2;
        System.out.println("\nRemoving " + n + "nd node from the end...");
        ListNode modifiedHead = removeNthFromEnd(head, n);

        System.out.println("Modified List:");
        printList(modifiedHead);

        // Case 2: Remove head (n = length)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("\nOriginal List: 1 -> 2");
        System.out.println("Removing 2nd node from the end (the head)...");
        ListNode modifiedHead2 = removeNthFromEnd(head2, 2);
        System.out.print("Modified List: ");
        printList(modifiedHead2);
    }

    private static void printList(ListNode node) {
        if (node == null) {
            System.out.println("Empty list");
            return;
        }
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
