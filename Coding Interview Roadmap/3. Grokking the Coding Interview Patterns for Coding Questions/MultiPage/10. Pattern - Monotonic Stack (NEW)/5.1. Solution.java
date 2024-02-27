import java.util.Stack;
import java.util.Arrays;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();  // Initialize a stack to store indices of temperatures.
        int[] res = new int[temperatures.length];  // Initialize a result array.

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // While the stack is not empty and the current temperature is higher
                // than the temperature at the index stored at the top of the stack:
                int idx = stack.pop();  // Pop the top index from the stack.
                res[idx] = i - idx;  // Calculate the number of days until warmer temperature.
            }
            stack.push(i);  // Push the current index onto the stack.
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures1 = {70, 73, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {73, 72, 71, 70};
        int[] temperatures3 = {70, 71, 72, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1))); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2))); // Output: [0, 0, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3))); // Output: [1, 1, 1, 0]
    }
}
import java.util.Stack;

/*class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}*/

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();  // Create a stack to store nodes in descending order

        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();  // Remove nodes from the stack that are smaller than the current node
            }
            if (!stack.isEmpty()) {
                stack.peek().next = cur;  // Update the next pointer of the top node in the stack
            }
            stack.push(cur);  // Push the current node onto the stack
            cur = cur.next;
        }

        return stack.isEmpty() ? null : stack.get(0);  // Return the head of the modified list, or null if the stack is empty
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating the linked list 5 -> 3 -> 7 -> 4 -> 2 -> 1
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next = new ListNode(1);
        head1 = solution.removeNodes(head1);

        // Printing the modified list: 7 -> 4 -> 2 -> 1
        ListNode node = head1;
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}
