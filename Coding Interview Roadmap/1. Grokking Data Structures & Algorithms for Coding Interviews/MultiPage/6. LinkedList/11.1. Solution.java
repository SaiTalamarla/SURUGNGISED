// class DLNode {
//     int val;
//     DLNode next, prev;
//     DLNode(int val) { this.val = val; }
// }

class Solution {
    public boolean isPalindrome(DLNode head) {
        if (head == null || head.next == null) return true;
        
        DLNode tail = head;
        while (tail.next != null) tail = tail.next; // Find the tail of the doubly linked list
        
        DLNode start = head;
        DLNode end = tail;
        
        while (start != end && start.prev != end) {
            if (start.val != end.val) return false; // Compare the values at start and end pointers
            start = start.next;
            end = end.prev;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        DLNode head1 = new DLNode(1);
        head1.next = new DLNode(2);
        head1.next.prev = head1;
        head1.next.next = new DLNode(1);
        head1.next.next.prev = head1.next;
        System.out.println(solution.isPalindrome(head1)); // Expected: true
    }
}
