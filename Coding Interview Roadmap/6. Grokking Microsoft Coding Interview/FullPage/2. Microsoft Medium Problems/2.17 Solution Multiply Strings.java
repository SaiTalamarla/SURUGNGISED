public class Solution {
    // Method to multiply two strings and return the product as a string
    public String multiplyStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n]; // Result can have at most m + n digits
        
        // Multiply each digit of num1 with each digit of num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // Multiply the digits
                int sum = mul + result[i + j + 1]; // Add to the current position
                
                result[i + j + 1] = sum % 10; // Set the current digit
                result[i + j] += sum / 10; // Handle carry
            }
        }
        
        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int p : result) if (!(sb.length() == 0 && p == 0)) sb.append(p); // Skip leading zeros
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    // Main method to test the algorithm with examples
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiplyStrings("4", "5")); // "20"
        System.out.println(solution.multiplyStrings("11", "11")); // "121"
        System.out.println(solution.multiplyStrings("999", "999")); // "998001"
    }
}
