/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}*/

class Solution {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;

    // find middle of the LinkedList
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode headSecondHalf = reverse(slow); // reverse the second half
    // store the head of reversed part to revert back later
    ListNode copyHeadSecondHalf = headSecondHalf; 

    // compare the first and the second half
    while (head != null && headSecondHalf != null) {
      if (head.val != headSecondHalf.val) {
        break; // not a palindrome
      }
      head = head.next;
      headSecondHalf = headSecondHalf.next;
    }

    reverse(copyHeadSecondHalf); // revert the reverse of the second half
    if (head == null || headSecondHalf == null) // if both halves match
      return true;
    return false;
  }

  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + sol.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + sol.isPalindrome(head));
  }
}
