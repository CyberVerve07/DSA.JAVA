package linkedlist;

/**
 * Problem 4: Linked List Cycle (LeetCode 141)
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached 
 * again by continuously following the next pointer.
 */
public class Problem4 {

    /**
     * Logic: Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
     * - Use two pointers: slow and fast.
     * - Move slow pointer by 1 step and fast pointer by 2 steps.
     * - If there is a cycle, the fast pointer will eventually catch up to the slow pointer within the cycle.
     * - If fast reaches null or fast.next is null, there is no cycle.
     * 
     * @param head Head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps

            if (slow == fast) {        // Cycle detected
                return true;
            }
        }

        return false; // Fast reached the end
    }

    public static void main(String[] args) {
        // Case 1: List with a cycle
        // 3 -> 2 -> 0 -> -4
        //      ^          |
        //      |__________|
        ListNode head1 = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        
        head1.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle back to the second node

        System.out.println("Case 1: List with a cycle");
        System.out.println("Has cycle? " + hasCycle(head1));

        // Case 2: List without a cycle
        // 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("\nCase 2: List without a cycle");
        System.out.println("Has cycle? " + hasCycle(head2));

        // Case 3: Single node without cycle
        ListNode head3 = new ListNode(1);
        System.out.println("\nCase 3: Single node list");
        System.out.println("Has cycle? " + hasCycle(head3));
    }
}
