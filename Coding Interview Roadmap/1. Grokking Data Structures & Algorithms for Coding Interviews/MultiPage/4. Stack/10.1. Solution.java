import java.util.Stack;

public class Solution {
    // Method to convert a decimal number to binary representation
    public String decimalToBinary(int num) {
        // Create a stack to store binary digits
        Stack<Integer> stack = new Stack<>();
        // Create a StringBuilder to build the binary representation
        StringBuilder sb = new StringBuilder();
        
        // Convert the decimal number to binary using a stack
        while (num > 0) {
            stack.push(num % 2); // Push the remainder (binary digit) onto the stack
            num /= 2;           // Divide the number by 2 for the next digit
        }
        
        // Pop the binary digits from the stack and append them to the StringBuilder
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        // Convert the StringBuilder to a string and return the binary representation
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test cases to convert decimal numbers to binary
        System.out.println(sol.decimalToBinary(2));   // Output: 10
        System.out.println(sol.decimalToBinary(7));   // Output: 111
        System.out.println(sol.decimalToBinary(18));  // Output: 10010
    }
}
