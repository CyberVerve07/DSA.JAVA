package linkedlist;

/**
 * Problem 3: Middle of the Linked List (LeetCode 876)
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class Problem3 {

    /**
     * Logic:
     * - Use slow and fast pointers.
     * - Slow pointer moves one step at a time, while fast pointer moves two steps.
     * - When fast reaches the end (null or fast.next is null), slow will be at the middle.
     * - This works because when fast moves twice the distance slow moves, slow ends up at halfway.
     * @param head Head of the linked list
     * @return The middle node
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Fast moves 2x, slow moves 1x.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Case 1: Odd number of elements: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("List 1: 1 -> 2 -> 3 -> 4 -> 5");
        ListNode mid1 = middleNode(head1);
        System.out.println("Middle element of List 1 is: " + mid1.val);

        // Case 2: Even number of elements: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        System.out.println("\nList 2: 1 -> 2 -> 3 -> 4 -> 5 -> 6");
        ListNode mid2 = middleNode(head2);
        System.out.println("Middle element of List 2 is: " + mid2.val);
    }
}
