package linkedlist;

/**
 * Problem 1: Reverse Linked List (LeetCode 206)
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class Problem1 {

    /**
     * Logic:
     * - Iterate through the list.
     * - Keep track of previous node (prev), current node (curr).
     * - Before changing curr.next, store curr.next in a temporary variable (nextTemp).
     * - Change curr.next to point to prev.
     * - Move prev to curr and curr to nextTemp.
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev;              // Reverse connection
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }
        
        return prev; // prev will be the new head
    }

    public static void main(String[] args) {
        // Create: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("\nReversed List:");
        printList(reversedHead);
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
