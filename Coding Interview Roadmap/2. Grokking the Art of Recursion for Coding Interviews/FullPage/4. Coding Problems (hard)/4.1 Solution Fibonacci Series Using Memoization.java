import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Integer, Integer> memoizationTable;

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n; // Base case: return n if n is 0 or 1
        }

        // Check if Fibonacci number is already calculated and stored in memoization table
        if (memoizationTable.containsKey(n)) {
            return memoizationTable.get(n);
        }

        // Calculate Fibonacci number using recursion
        int fib = fibonacci(n - 1) + fibonacci(n - 2);

        // Store Fibonacci number in memoization table for future use
        memoizationTable.put(n, fib);

        return fib;
    }

    public static void main(String[] args) {
        memoizationTable = new HashMap<>();

        // Example inputs
        int[] examples = {5, 8, 12};

        for (int n : examples) {
            System.out.print("Fibonacci Series up to " + n + ": ");
            for (int i = 0; i <= n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
            System.out.println();
        }
    }
}
