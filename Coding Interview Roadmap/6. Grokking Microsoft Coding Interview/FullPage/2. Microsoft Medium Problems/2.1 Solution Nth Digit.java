public class Solution {
    public int findNthDigit(int n) {
        int digitLength = 1; // Starting with single-digit numbers
        long count = 9; // Count of digits for the current digit length
        long start = 1; // The starting number of the current digit length range

        // Find the digit length where the nth digit falls
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Find the exact number that contains the nth digit
        start += (n - 1) / digitLength;
        String targetNumber = Long.toString(start);
        // Extract the nth digit from the number
        return Character.getNumericValue(targetNumber.charAt((n - 1) % digitLength));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(3)); // Example 1
        System.out.println(solution.findNthDigit(110000)); // Example 2
        System.out.println(solution.findNthDigit(15)); // Example 3
    }
}
