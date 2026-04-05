package linkedlist;

/**
 * Problem 2: Merge Two Sorted Lists (LeetCode 21)
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 */
public class Problem2 {

    /**
     * Logic:
     * - Use a dummy node to act as the head of the resulting merged list.
     * - Create a `curr` pointer to keep track of the end of the merged list.
     * - Compare values of the nodes at the head of local lists `l1` and `l2`.
     * - Point `curr.next` to the smaller value node and move that list's pointer.
     * - After one list is exhausted, connect the remainder of the other list to `curr.next`.
     * - Return `dummy.next`.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes
        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // List 1: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // List 2: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        ListNode mergedHead = mergeTwoLists(l1, l2);

        System.out.println("\nMerged List:");
        printList(mergedHead);
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
