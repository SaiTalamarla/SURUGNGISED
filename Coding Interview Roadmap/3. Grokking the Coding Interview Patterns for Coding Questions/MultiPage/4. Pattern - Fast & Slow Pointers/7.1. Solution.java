/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}*/

class Solution {

  public ListNode findCycleStart(ListNode head) {
    int cycleLength = 0;

    // Find the LinkedList cycle using Floyd's Tortoise and Hare algorithm
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next; // Move two steps at a time
      slow = slow.next;      // Move one step at a time
      if (slow == fast) {    // Found the cycle
        cycleLength = calculateCycleLength(slow);
        break;
      }
    }

    return findStart(head, cycleLength);
  }

  private static int calculateCycleLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;

    // Calculate the length of the cycle by moving through it
    do {
      current = current.next;
      cycleLength++;
    } while (current != slow);

    return cycleLength;
  }

  private static ListNode findStart(ListNode head, int cycleLength) {
    ListNode pointer1 = head, pointer2 = head;

    // Move pointer2 ahead 'cycleLength' nodes
    while (cycleLength > 0) {
      pointer2 = pointer2.next;
      cycleLength--;
    }

    // Increment both pointers until they meet at the start of the cycle
    while (pointer1 != pointer2) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    return pointer1;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    // Create a cycle by connecting nodes
    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + sol.findCycleStart(head).val);

    // Create a different cycle
    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + sol.findCycleStart(head).val);

    // Create a cycle that points back to the head
    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + sol.findCycleStart(head).val);
  }
}
