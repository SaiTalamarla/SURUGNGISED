class Solution {

  public int countWays(int n) {
    if( n == 0)
      return 1; // base case, we don't need to subtract any thing, so there is only one way

    if(n == 1)
      return 1; // we can subtract 1 to be left with zero, and that is the only way

    if(n == 2)
      return 1; // we can subtract 1 twice to get zero and that is the only way

    if(n == 3)
      return 2; // '3' can be expressed as {1,1,1}, {3}
      
    // if we subtract 1, we are left with 'n-1'
    int subtract1 = countWays(n-1);
    // if we subtract 3, we are left with 'n-3'
    int subtract3 = countWays(n-3);
    // if we subtract 4, we are left with 'n-4'
    int subtract4 = countWays(n-4);

    return subtract1 + subtract3 + subtract4;
  }

  public static void main(String[] args) {
    Solution en = new Solution();
    System.out.println(en.countWays(4));
    System.out.println(en.countWays(5));
    System.out.println(en.countWays(6));
  }
}
