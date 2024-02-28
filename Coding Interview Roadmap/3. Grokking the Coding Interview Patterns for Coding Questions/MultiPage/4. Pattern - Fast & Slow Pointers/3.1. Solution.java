/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}*/

class Solution {

  public boolean hasCycle(ListNode head) {
    ListNode slow = head; // Initialize a slow pointer to the head of the linked list.
    ListNode fast = head; // Initialize a fast pointer to the head of the linked list.
    while (fast != null && fast.next != null) { // Iterate through the linked list.
      fast = fast.next.next; // Move the fast pointer two steps at a time.
      slow = slow.next; // Move the slow pointer one step at a time.
      if (slow == fast) // Check if the slow and fast pointers meet, indicating a cycle.
        return true; // Found a cycle, return true.
    }
    return false; // No cycle found, return false.
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    System.out.println("LinkedList has cycle: " + sol.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next; // Creating a cycle by connecting the last node to the third node.
    System.out.println("LinkedList has cycle: " + sol.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next; // Creating a cycle by connecting the last node to the fourth node.
    System.out.println("LinkedList has cycle: " + sol.hasCycle(head));
  }
}
