public class Solution {
    public static int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1; // Base case
        }
        return number * calculateFactorial(number - 1); // Recursive call
    }

    public static void main(String[] args) {
        // Example inputs
        int[] examples = {5, 7, 1};

        for (int number : examples) {
            int factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + ": " + factorial);
        }
    }
}
