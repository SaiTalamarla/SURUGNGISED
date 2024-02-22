import java.util.Arrays;
import java.util.List;

public class Solution {

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isGoodNumber(String digits, int index) {
        if (index >= digits.length())
            return true;  // Base case: reached the end of the string

        char digit = digits.charAt(index);

        // Check if the digit at the current index satisfies the conditions
        if ((index % 2 == 0 && (digit - '0') % 2 != 0) || (index % 2 != 0 && !isPrime(digit - '0')))
            return false;

        // Recursively check the next digit
        return isGoodNumber(digits, index + 1);
    }

    public static void main(String[] args) {
        // Example inputs
        List<String> digitStrings = Arrays.asList("02468", "23478", "123456");

        for (String digits : digitStrings) {
            boolean isGood = isGoodNumber(digits, 0);
            System.out.println("Digit string: " + digits + " is " + (isGood ? "good" : "not good"));
        }
    }
}
