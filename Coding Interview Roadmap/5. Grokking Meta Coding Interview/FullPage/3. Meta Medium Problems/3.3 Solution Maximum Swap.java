public class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] maxIndexAfter = new int[digits.length];
        int maxIdx = digits.length - 1;
        
        // Finding the index of the maximum digit after each digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIdx]) {
                maxIdx = i;
            }
            maxIndexAfter[i] = maxIdx;
        }

        // Swapping the first non-maximum digit
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != digits[maxIndexAfter[i]]) {
                char temp = digits[i];
                digits[i] = digits[maxIndexAfter[i]];
                digits[maxIndexAfter[i]] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        System.out.println(solution.maximumSwap(2736));  // Output: 7236
        // Example 2
        System.out.println(solution.maximumSwap(9965));  // Output: 9965
        // Example 3
        System.out.println(solution.maximumSwap(7281912));  // Output: 9281712
    }
}
