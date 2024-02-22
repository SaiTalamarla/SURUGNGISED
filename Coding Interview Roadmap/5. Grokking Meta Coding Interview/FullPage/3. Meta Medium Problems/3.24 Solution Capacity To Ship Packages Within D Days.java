public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // Initialize the lower and upper bounds
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);  // Lower bound is the max weight
            right += w;                // Upper bound is the sum of all weights
        }

        // Binary search to find the minimum capacity
        while (left < right) {
            int mid = (left + right) / 2;  // Calculate the middle value
            int need = 1, cur = 0;         // Variables to track the number of days and current weight

            // Check if it's possible to ship all packages within D days using the mid capacity
            for (int w : weights) {
                if (cur + w > mid) {
                    need += 1;  // Increment the day count if current weight exceeds mid capacity
                    cur = 0;    // Reset current weight
                }
                cur += w;       // Add weight to current
            }

            // Adjust the search bounds based on the feasibility
            if (need > D) left = mid + 1;  // Increase lower bound if more days are needed
            else right = mid;              // Decrease upper bound if it's feasible
        }

        return left;  // The minimum capacity required
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] weights1 = {10, 20, 30, 40, 50};
        int days1 = 3;
        System.out.println("Example 1: " + solution.shipWithinDays(weights1, days1));  // Expected output: 60

        // Example 2
        int[] weights2 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int days2 = 5;
        System.out.println("Example 2: " + solution.shipWithinDays(weights2, days2));  // Expected output: 10

        // Example 3
        int[] weights3 = {4, 8, 5, 2, 6, 3, 7, 9};
        int days3 = 4;
        System.out.println("Example 3: " + solution.shipWithinDays(weights3, days3));  // Expected output: 13
    }
}