import java.util.Stack;
import java.util.EmptyStackException;

// Class MyStack, a generic class to implement a stack data structure.
public class MyStack<T> {
    // A Stack object to store the elements.
    private Stack<T> stack = new Stack<>();

    // Method to check if the stack is empty.
    public boolean isEmpty() {
        return stack.empty(); // Returns true if the stack is empty, false otherwise.
    }

    // Method to add an element to the top of the stack.
    public void push(T data) {
        stack.push(data); // Adds 'data' to the top of the stack.
    }

    // Method to remove and return the top element of the stack.
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throws an exception if the stack is empty.
        }
        return stack.pop(); // Returns and removes the top element of the stack.
    }

    // Method to return the top element of the stack without removing it.
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throws an exception if the stack is empty.
        }
        return stack.peek(); // Returns the top element of the stack without removing it.
    }
}
