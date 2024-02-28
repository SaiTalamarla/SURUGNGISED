import java.util.Arrays; // Import Arrays class

public class Solution {
    public String largestPalindromic(String num) {
        // Count the frequency of each digit in the input number
        int[] freq = new int[10];  // Initialize a frequency array for digits 0-9
        for (int i = 0; i < num.length(); i++) {
            freq[num.charAt(i) - '0']++;  // Increment the count for each digit
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";
        for (int i = 9; i >= 0; i--) {  // Iterate from the highest digit (9) to the lowest (0)
            if (freq[i] % 2 != 0 && middle.isEmpty()) {  // Check if the digit count is odd and middle is empty
                middle = Integer.toString(i);  // Assign the largest odd-count digit as the middle digit
            }
            char[] half = new char[freq[i] / 2];
            Arrays.fill(half, (char) (i + '0'));
            firstHalf.append(new String(half));  // Add half of the even-count digits to the first half
        }

        // Handle special cases
        if (firstHalf.length() == 0) {
            return middle.isEmpty() ? "0" : middle;  // Return the middle digit or "0"
        } else if (firstHalf.toString().matches("^0+$")) {
            return "0";  // Case for multiple zeros
        }
        // Construct the final palindrome
        return firstHalf.toString() + middle + firstHalf.reverse().toString();  // Concatenate the first half, middle digit, and the reversed first half
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPalindromic("323211444")); // 432141234
        System.out.println(solution.largestPalindromic("998877"));     // 987789
        System.out.println(solution.largestPalindromic("54321"));      // 5
    }
}
