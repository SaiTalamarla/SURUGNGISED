public class Solution {
    public static int calculateSum(int N) {
        if (N <= 0) {
            return 0; // Base case
        }
        return N + calculateSum(N - 1); // Recursive call
    }

    public static void main(String[] args) {
        // Example inputs
        int[] examples = {5, 10, 1};

        for (int N : examples) {
            int sum = calculateSum(N);
            System.out.println("Sum of first " + N + " natural numbers: " + sum);
        }
    }
}
