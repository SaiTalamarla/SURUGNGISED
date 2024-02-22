// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//     }
// }

public class Solution {

    public static ListNode removeNodes(ListNode head, int target) {
        // Base case: If the list is empty, return null
        if (head == null) {
            return null;
        }

        // Recursively remove nodes with target value from the remaining list
        head.next = removeNodes(head.next, target);

        // Check if the current node has the target value
        if (head.val == target) {
            // Skip the current node and return the modified list
            return head.next;
        }

        // Return the current node as the new head of the modified list
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(2);

        System.out.print("Original Linked List 1: ");
        printLinkedList(head1);

        // Remove nodes with value 2 from linked list
        ListNode modifiedHead1 = removeNodes(head1, 2);
        System.out.print("Modified Linked List 1: ");
        printLinkedList(modifiedHead1);

        // Example 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(2);

        System.out.print("Original Linked List 2: ");
        printLinkedList(head2);

        // Remove nodes with value 2 from linked list
        ListNode modifiedHead2 = removeNodes(head2, 2);
        System.out.print("Modified Linked List 2: ");
        printLinkedList(modifiedHead2);

        // Example 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(5);
        head3.next.next.next = new ListNode(7);

        System.out.print("Original Linked List 3: ");
        printLinkedList(head3);

        // Remove nodes with value 2 from linked list
        ListNode modifiedHead3 = removeNodes(head3, 2);
        System.out.print("Modified Linked List 3: ");
        printLinkedList(modifiedHead3);
    }
}
