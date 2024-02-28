// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next; // store next node
            current.next = prev; // reverse the link
            prev = current; // move one step forward in the list
            current = next; // move one step forward in the list
        }
        return prev; // prev is now pointing to the new head
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(2);
        printList(solution.reverseList(head1)); // Expected Output: 2 5 3

        // Test case 2
        ListNode head2 = new ListNode(7);
        printList(solution.reverseList(head2)); // Expected Output: 7

        // Test case 3
        ListNode head3 = new ListNode(-1);
        head3.next = new ListNode(0);
        head3.next.next = new ListNode(1);
        printList(solution.reverseList(head3)); // Expected Output: 1 0 -1
    }
}
