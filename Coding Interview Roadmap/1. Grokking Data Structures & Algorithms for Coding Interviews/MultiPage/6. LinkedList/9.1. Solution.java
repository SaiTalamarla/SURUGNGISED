// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

public class Solution {
    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Initialize a dummy node and a current pointer
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // Traverse through both lists until one is exhausted
        while(l1 != null && l2 != null) {
            // Compare nodes and append the smaller one to current
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Append the remaining nodes from the non-empty list
        if(l1 != null) current.next = l1;
        else current.next = l2;
        
        // Return the merged sorted list
        return dummy.next;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create the first example ListNode instances
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(1, new ListNode(4));

        // Call mergeTwoLists method and print the result
        ListNode result = solution.mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
