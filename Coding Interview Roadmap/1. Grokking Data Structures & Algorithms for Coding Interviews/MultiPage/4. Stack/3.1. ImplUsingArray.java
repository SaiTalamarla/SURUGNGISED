import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] stack; // An array to store the elements of the stack
    private int top; // An integer to keep track of the top element's index
    
    // Constructor to initialize the stack with a specified size
    public Stack(int size) {
        stack = new Object[size]; // Create a new array of objects with the given size
        top = -1; // Initialize the top index to -1, indicating an empty stack
    }

    // Method to push an item onto the stack
    public void push(T item) {
        if (top == stack.length - 1) {
            throw new IndexOutOfBoundsException("Stack is full"); // Check if the stack is full and throw an exception if it is
        }
        stack[++top] = item; // Increment the top index and add the item to the stack
    }

    // Method to pop and remove the top item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Check if the stack is empty and throw an exception if it is
        }
        T item = (T) stack[top]; // Retrieve the top item from the stack
        stack[top--] = null; // Set the top element to null and decrement the top index
        return item; // Return the removed item
    }

    // Method to peek at the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Check if the stack is empty and throw an exception if it is
        }
        return (T) stack[top]; // Return the top item without removing it
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if the top index is -1, indicating an empty stack
    }
}
