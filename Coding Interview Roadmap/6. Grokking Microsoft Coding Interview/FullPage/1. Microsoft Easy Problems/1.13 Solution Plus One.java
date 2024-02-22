public class Solution {
    public int[] plusOne(int[] digits) {
        // Iterate from the end to the start of the array
        for (int i = digits.length - 1; i >= 0; i--) {
            // If current digit is less than 9, simply increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set it to 0 and continue to next digit for possible carry
            digits[i] = 0;
        }
        
        // If all digits were 9, array size increases. Create new array with leading 1
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1; // Leading 1 represents the carry over from the last 9's
        return newDigits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example inputs
        int[][] examples = {{1, 2, 3}, {4, 9, 9, 9}, {9, 8, 7, 6, 8, 9, 9, 9}};
        // Process each example
        for (int[] example : examples) {
            int[] result = solution.plusOne(example);
            for (int digit : result) {
                System.out.print(digit);
            }
            System.out.println();
        }
    }
}
