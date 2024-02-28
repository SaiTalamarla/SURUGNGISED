import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initialize an empty stack and a result array filled with zeros
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        // Iterate through the list of temperatures
        for (int i = 0; i < temperatures.length; i++) {
            // Pop indices from the stack while the current temperature is greater than the temperature at the popped index
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        // Return the final result array
        return res;
    }

    // Function to print an array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Testing the algorithm
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] example1 = {45, 50, 40, 60, 55};
        int[] example2 = {80, 75, 85, 90, 60};
        int[] example3 = {32, 32, 32, 32, 32};
        
        // Output: [1, 2, 1, 0, 0]
        printArray(solution.dailyTemperatures(example1));
        // Output: [2, 1, 1, 0, 0]
        printArray(solution.dailyTemperatures(example2));
        // Output: [0, 0, 0, 0, 0]
        printArray(solution.dailyTemperatures(example3));
    }
}
