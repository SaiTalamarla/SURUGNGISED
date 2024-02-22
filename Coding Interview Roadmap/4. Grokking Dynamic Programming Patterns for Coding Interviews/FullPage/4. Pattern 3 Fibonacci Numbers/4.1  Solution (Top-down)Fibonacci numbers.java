class Solution {

  public int calculateFibonacci(int n) {
    int dp[] = new int[n + 1];
    return calculateFibonacciRecursive(dp, n);
  }

  public int calculateFibonacciRecursive(int[] dp, int n) {
    if (n < 2)
      return n;
    if (dp[n] == 0)
      dp[n] = calculateFibonacciRecursive(dp, n - 1) + calculateFibonacciRecursive(dp, n - 2);
    return dp[n];
  }

  public static void main(String[] args) {
    Solution fib = new Solution();
    System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));
  }
}
