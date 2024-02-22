public class Solution {
    public static boolean isPerfectSquare(int num) {
        return isPerfectSquareHelper(num, 0, num);
    }

    private static boolean isPerfectSquareHelper(int num, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = low + (high - low) / 2;

        if ((long) mid * mid == num) {
            return true;
        } else if ((long) mid * mid > num) {
            return isPerfectSquareHelper(num, low, mid - 1);
        } else {
            return isPerfectSquareHelper(num, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] examples = {16, 14, 9};

        for (int num : examples) {
            boolean isPerfect = isPerfectSquare(num);
            System.out.println(num + " is a perfect square: " + isPerfect);
        }
    }
}
