/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}*/

public class Solution {

  public ListNode findMiddle(ListNode head) {
    ListNode slow = head;         // Initialize slow pointer at the head of the list
    ListNode fast = head;         // Initialize fast pointer at the head of the list
    while (fast != null && fast.next != null) {  // Traverse the list using slow and fast pointers
      slow = slow.next;          // Move slow pointer one step at a time
      fast = fast.next.next;     // Move fast pointer two steps at a time
    }

    return slow;  // Return the node pointed to by slow (middle node or middle-left node)
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle Node: " + sol.findMiddle(head).val);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle Node: " + sol.findMiddle(head).val);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle Node: " + sol.findMiddle(head).val);
  }
}
