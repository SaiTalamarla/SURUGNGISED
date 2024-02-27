import java.util.*;

class Solution {
    // Method to sort a given stack in ascending order
    public Stack<Integer> sortStack(Stack<Integer> input) {
        // Create a temporary stack to hold sorted elements
        Stack<Integer> tmpStack = new Stack<Integer>();
        
        // Iterate through the input stack until it is empty
        while(!input.isEmpty()) {
            // Pop the top element from the input stack
            int tmp = input.pop();
            
            // Compare the element with the top element of the temporary stack
            // and move elements from tmpStack to input stack until the correct position is found
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                input.push(tmpStack.pop());
            }
            
            // Push the current element to the temporary stack in the correct sorted position
            tmpStack.push(tmp);
        }
        
        // Return the sorted stack
        return tmpStack;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        // Create a new stack called 'input'
        Stack<Integer> input = new Stack<Integer>();
        
        // Add elements to the 'input' stack
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
        
        // Display the original input stack
        System.out.println("Input: " + input);
        
        // Call the sort method to sort the input stack
        Stack<Integer> sortedOutput = sol.sortStack(input);
        
        // Display the sorted output stack
        System.out.println("Sorted Output: " + sortedOutput);
    }
}
