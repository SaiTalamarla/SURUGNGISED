import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Solution {
    // Declare a static Queue of Integer type.
    static Queue<Integer> queue;

    // Define a static method to reverse the order of elements in the queue.
    Queue<Integer> reverseQueue(Queue<Integer> q) {
        // Create a Stack to temporarily hold the elements from the queue.
        Stack<Integer> stack = new Stack<>();
        
        // Transfer elements from the queue to the stack.
        // This will reverse the order of elements because stacks follow LIFO order.
        while (!q.isEmpty()) {
            // Add the front element of the queue to the stack.
            stack.add(q.peek());
            // Remove the front element from the queue.
            q.remove();
        }
        
        // Transfer elements back from the stack to the queue.
        // The order of elements will now be reversed in the queue.
        while (!stack.isEmpty()) {
            // Add the top element of the stack to the queue.
            q.add(stack.peek());
            // Remove the top element from the stack.
            stack.pop();
        }
        return q;
    }

    // Define the main method to test the reverseQueue method.
    public static void main(String[] args) {
        // Initialize the queue and add some elements to it.
        queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        // Call the method to reverse the order of elements in the queue.
        Solution sol = new Solution();
        sol.reverseQueue(queue);
        
        // Print the reversed queue to the console.
        System.out.println(queue);
    }
}
