import java.util.EmptyStackException;

public class Stack<T> {
    // Private inner class representing a Node in the stack
    private static class Node<T> {
        private T data;         // Data stored in the node
        private Node<T> next;   // Reference to the next node in the stack

        // Constructor to create a new node with the given data
        private Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;  // Reference to the top node of the stack

    // Pop operation: Removes and returns the top element of the stack
    public T pop() {
        // Check if the stack is empty
        if (top == null) {
            throw new EmptyStackException(); // Throw an exception if it's empty
        }
        T item = top.data;  // Get the data from the top node
        top = top.next;     // Move the top reference to the next node
        return item;        // Return the removed item
    }

    // Push operation: Pushes a new item onto the top of the stack
    public void push(T item) {
        Node<T> t = new Node<T>(item);  // Create a new node with the given data
        t.next = top;                   // Set the new node's next reference to the current top
        top = t;                        // Update the top reference to the new node
    }

    // Peek operation: Returns the top element of the stack without removing it
    public T peek() {
        // Check if the stack is empty
        if (top == null) {
            throw new EmptyStackException(); // Throw an exception if it's empty
        }
        return top.data;  // Return the data of the top node
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
