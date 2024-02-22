public class Solution {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false; // Base case 1
        }
        if (number == 2) {
            return true; // Base case 2
        }
        return checkDivisors(number, 2); // Recursive call
    }

    private static boolean checkDivisors(int number, int divisor) {
        if (divisor > Math.sqrt(number)) {
            return true; // Base case 3
        }
        if (number % divisor == 0) {
            return false; // Number is divisible, not prime
        }
        return checkDivisors(number, divisor + 1); // Recursive call
    }

    public static void main(String[] args) {
        // Example inputs
        int[] examples = {7, 12, 23};

        for (int example : examples) {
            boolean isPrime = isPrime(example);
            System.out.println(example + " is prime: " + isPrime);
        }
    }
}
