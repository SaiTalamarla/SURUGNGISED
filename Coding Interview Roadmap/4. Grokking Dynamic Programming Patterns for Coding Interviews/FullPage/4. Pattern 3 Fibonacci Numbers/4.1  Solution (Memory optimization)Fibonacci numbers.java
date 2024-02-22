class Solution {

  public int calculateFibonacci(int n) {
    if (n < 2)
      return n;
    int n1 = 0, n2 = 1, temp;
    for (int i = 2; i <= n; i++) {
      temp = n1 + n2;
      n1 = n2;
      n2 = temp;
    }
    return n2;
  }

  public static void main(String[] args) {
    Solution fib = new Solution();
    System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));
  }
}
