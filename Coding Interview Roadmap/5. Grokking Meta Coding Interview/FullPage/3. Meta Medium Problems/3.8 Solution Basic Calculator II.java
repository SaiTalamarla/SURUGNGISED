public class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // Building the current number if it's a digit
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            // Performing calculation upon encountering an operator or at the end of the string
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (operation == '+' || operation == '-') {
                    // For '+' and '-', add lastNumber to result and update lastNumber
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    // For '*', multiply lastNumber with currentNumber
                    lastNumber *= currentNumber;
                } else if (operation == '/') {
                    // For '/', divide lastNumber by currentNumber
                    lastNumber /= currentNumber;
                }
                operation = currentChar; // Update the operation
                currentNumber = 0; // Reset currentNumber
            }
        }
        result += lastNumber; // Add the last number to result
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("50-25+5*3/2*2-10/2")); // Example test case
    }
}
