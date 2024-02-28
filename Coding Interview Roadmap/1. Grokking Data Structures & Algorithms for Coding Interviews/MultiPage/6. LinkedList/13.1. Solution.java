// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode swapPairs(ListNode head) {
        // Initialize a dummy node to maintain the new head of the list after swapping.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Previous node to maintain the node previous to the current pair being swapped.
        ListNode previous = dummy;
        
        // Continue swapping until no pairs are left.
        while (head != null && head.next != null) {
            // Initialize the first and second nodes of the pair to be swapped.
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            
            // Adjust the pointers to perform the swap.
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            previous.next = secondNode;
            
            // Move to the next pair.
            head = firstNode.next;
            previous = firstNode;
        }
        // Return the new head of the list after swapping.
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Initialize the list and perform the swap.
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode newHead = solution.swapPairs(head);
        // Print the list after swapping pairs.
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
