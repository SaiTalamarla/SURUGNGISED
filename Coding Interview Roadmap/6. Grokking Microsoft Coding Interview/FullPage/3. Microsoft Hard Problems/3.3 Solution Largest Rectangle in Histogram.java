import java.util.Stack;

public class Solution {
    // Method to calculate the largest rectangle area
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of heights
        int maxArea = 0; // Variable to store the maximum area
        for (int i = 0; i <= heights.length; i++) { // Loop through the heights array
            int h = (i == heights.length) ? 0 : heights[i]; // Set h to 0 if i exceeds array length
            while (!stack.isEmpty() && h < heights[stack.peek()]) { // Check for previous heights higher than current
                int height = heights[stack.pop()]; // Get the height of the popped element
                int width = stack.isEmpty() ? i : i - 1 - stack.peek(); // Calculate width of rectangle
                maxArea = Math.max(maxArea, height * width); // Update maxArea if current area is greater
            }
            stack.push(i); // Push the current index onto the stack
        }
        return maxArea; // Return the maximum area
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution(); // Create an instance of the Solution class
        // Example 1
        System.out.println(solution.largestRectangleArea(new int[]{4, 2, 0, 3, 2})); 
        // Example 2
        System.out.println(solution.largestRectangleArea(new int[]{1, 3, 4, 5, 2})); 
        // Example 3
        System.out.println(solution.largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }
}