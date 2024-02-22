class Solution {

  public int countWays(int n) {
    if( n == 0)
      return 1; // base case, we don't need to take any step, so there is only one way
      
    if(n == 1)
      return 1; // we can take one step to reach the end, and that is the only way

    if(n == 2)
      return 2; // we can take one step twice or jump two steps to reach at the top

    // if we take 1 step, we are left with 'n-1' steps;
    int take1Step = countWays(n-1); 
    // similarly, if we took 2 steps, we are left with 'n-2' steps;
    int take2Step = countWays(n-2); 
    // if we took 3 steps, we are left with 'n-3' steps;
    int take3Step = countWays(n-3); 

    return take1Step + take2Step + take3Step;
  }

  public static void main(String[] args) {
    Solution sc = new Solution();
    System.out.println(sc.countWays(3));
    System.out.println(sc.countWays(4));
    System.out.println(sc.countWays(5));
  }
}
