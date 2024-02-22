public class Solution {
    public static int calculateGCD(int A, int B) {
        if (B == 0) {
            return A; // Base case
        }
        return calculateGCD(B, A % B); // Recursive call
    }

    public static void main(String[] args) {
        // Example inputs
        int[][] examples = {{12, 18}, {25, 15}, {40, 60}};

        for (int[] example : examples) {
            int A = example[0];
            int B = example[1];
            int gcd = calculateGCD(A, B);
            System.out.println("GCD of " + A + " and " + B + " is: " + gcd);
        }
    }
}
