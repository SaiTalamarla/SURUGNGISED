// Definition for singly-linked list.
// private static class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

public class Solution {
    // Method to sort the list
    public ListNode sortList(ListNode head) {
        // Base case: a single node or empty list is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list to divide it into two halves
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Disconnect the first half from the second half
        prev.next = null;

        // Recursively sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Merge the two sorted halves and return
        return merge(l1, l2);
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            // Compare values from each list and append the smaller one
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // Append any remaining nodes from either list
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next; // Return the head of the merged list
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Constructing the linked list for Example 3
        int[] values = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        // Apply the sorting algorithm
        head = solution.sortList(head);

        // Display the sorted list
        System.out.println("Sorted List:");
        printList(head);
    }

    // Helper method to print the list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
