// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Initialize the current node as the head of the list.
        ListNode current = head;
        
        // Traverse through the list until the end is reached.
        while (current != null && current.next != null) {
            // If the next node is a duplicate, bypass it.
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                // If not, move to the next node.
                current = current.next;
            }
        }
        // Return the modified head of the list.
        return head;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result1 = solution.deleteDuplicates(head1); // Expected: 1 -> 2
        solution.printList(result1);

        // Test Example 2
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
        ListNode result2 = solution.deleteDuplicates(head2); // Expected: 1 -> 2 -> 3
        solution.printList(result2);
        
        // Test Example 3
        ListNode head3 = new ListNode(3, new ListNode(3, new ListNode(3)));
        ListNode result3 = solution.deleteDuplicates(head3); // Expected: 3
        solution.printList(result3);
    }
}
