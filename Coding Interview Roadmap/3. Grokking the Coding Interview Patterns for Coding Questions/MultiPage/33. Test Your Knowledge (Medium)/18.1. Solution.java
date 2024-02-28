// class ListNode {
//     int val = 0;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//         next = null;
//     }
// }

public class Solution {
    public static ListNode removeNth(ListNode head, int n) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n nodes ahead
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Solution.removeNth(head, 2);
        System.out.print("Nodes after removing the Nth node from the end: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
