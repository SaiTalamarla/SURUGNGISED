import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Create two Queues, 'main' and 'aux', for stack implementation
    Queue<Integer> main = new LinkedList<Integer>();
    Queue<Integer> aux = new LinkedList<Integer>();

    public void push(int x) {
        // Push the value into 'aux' Queue
        aux.add(x);
        // Move all elements from 'main' to 'aux', effectively reversing the order
        while (!main.isEmpty()) {
            aux.add(main.remove());
        }
        // Swap 'main' and 'aux' Queues to maintain the correct stack order
        Queue<Integer> temp = main;
        main = aux;
        aux = temp;
    }

    public int pop() {
        // Pop and return the top element from 'main' Queue, which simulates popping from the stack
        return main.remove();
    }

    public static void main(String[] args) {
        Solution stack = new Solution();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Should print 3 (last pushed element)
        System.out.println(stack.pop());  // Should print 2 (element pushed before 3)
    }
}
