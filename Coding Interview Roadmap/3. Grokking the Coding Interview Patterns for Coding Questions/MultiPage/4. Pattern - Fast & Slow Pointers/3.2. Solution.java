/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}*/

class Solution {

  public int findCycleLength(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next; // Move fast pointer two steps at a time
      slow = slow.next;      // Move slow pointer one step at a time
      if (slow == fast) // Found the cycle
        return calculateLength(slow); // Calculate the cycle length
    }
    return 0; // No cycle found
  }

  private static int calculateLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;
    do {
      current = current.next; // Move through the cycle
      cycleLength++;          // Count the cycle length
    } while (current != slow); // Continue until we reach the slow pointer again
    return cycleLength;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = head.next.next; // Creating a cycle in the linked list
    System.out.println("LinkedList cycle length: " 
                          + sol.findCycleLength(head));

    head.next.next.next.next.next.next = head.next.next.next; // Adjusting the cycle
    System.out.println("LinkedList cycle length: " 
                          + sol.findCycleLength(head));
  }
}
