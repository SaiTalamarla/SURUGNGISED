public class Solution {
    // Method to calculate the minimum additions to balance the parentheses
    public int minAddToMakeValid(String S) {
        int balance = 0, counter = 0;
        for (char c : S.toCharArray()) {
            balance += c == '(' ? 1 : -1;
            // If balance is negative, we have an unmatched closing parenthesis
            if (balance == -1) {
                counter++;
                balance++;
            }
        }
        // counter + balance gives the total number of parentheses needed
        return counter + balance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Testing the algorithm with the three examples
        System.out.println(solution.minAddToMakeValid("(()"));    // Example 1
        System.out.println(solution.minAddToMakeValid("))(("));   // Example 2
        System.out.println(solution.minAddToMakeValid("(()())(")); // Example 3
    }
}
