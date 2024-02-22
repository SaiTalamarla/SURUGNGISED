class Solution {

  public int calculateFibonacci(int n) {
    if(n < 2)
      return n;
    return calculateFibonacci(n-1) + calculateFibonacci(n-2);
  }

  public static void main(String[] args) {
    Solution fib = new Solution();
    System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));
  }
}
