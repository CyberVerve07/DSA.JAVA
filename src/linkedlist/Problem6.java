package linkedlist;

/**
 * Problem 6: Palindrome Linked List (LeetCode 234)
 * Given the head of a singly linked list, return true if it is a palindrome,
 * otherwise return false.
 */
public class Problem6 {

    /**
     * Logic:
     * - Use slow and fast pointers to find the middle of the list.
     * - Reverse the second half of the list.
     * - Compare the first half and reversed second half node by node.
     * - If all values match, the list is a palindrome.
     *
     * @param head Head of the linked list
     * @return true if the linked list is a palindrome, false otherwise
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = buildList(1, 2, 2, 1);
        System.out.println("List 1:");
        printList(head1);
        System.out.println("Is palindrome? " + isPalindrome(head1));

        ListNode head2 = buildList(1, 2, 3, 2, 1);
        System.out.println("\nList 2:");
        printList(head2);
        System.out.println("Is palindrome? " + isPalindrome(head2));

        ListNode head3 = buildList(1, 2);
        System.out.println("\nList 3:");
        printList(head3);
        System.out.println("Is palindrome? " + isPalindrome(head3));
    }

    private static ListNode buildList(int... values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
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
