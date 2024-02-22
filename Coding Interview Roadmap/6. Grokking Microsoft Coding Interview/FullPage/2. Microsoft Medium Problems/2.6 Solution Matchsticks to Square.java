import java.util.Arrays;

public class Solution {
    // Determines if matchsticks can form a square
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) return false; // Early return if total not divisible by 4
        int sideLength = totalLength / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks); // Start with largest matchsticks for efficiency
        return backtrack(matchsticks, new int[4], 0, sideLength);
    }

    // Backtracks through possible distributions of matchsticks to sides
    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            // Check if all sides are equal to the target length
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) continue; // Skip if side exceeds target
            sides[i] += matchsticks[index]; // Place matchstick
            if (backtrack(matchsticks, sides, index + 1, target)) return true;
            sides[i] -= matchsticks[index]; // Remove matchstick (backtrack)
        }
        return false;
    }

    // Reverses the matchsticks array to start with the largest
    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makesquare(new int[]{5, 5, 5, 5})); // true
        System.out.println(solution.makesquare(new int[]{3, 3, 3, 3, 4})); // false
        System.out.println(solution.makesquare(new int[]{1,1,2,1,2,1})); // true
    }
}
