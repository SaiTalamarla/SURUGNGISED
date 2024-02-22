class Solution {

  public int countWays(int n) {
    // bottom up 
    int n0 = 1, n1 = 1, n2 = 1, n3 = 2;
    for(int i = 4; i <= n; i++){
      int temp = n0 + n1 + n3;
      n0 = n1;
      n1 = n2;
      n2 = n3;
      n3 = temp;
    }
    return n3;
  }

  public static void main(String[] args) {
    Solution en = new Solution();
    System.out.println(en.countWays(4));
    System.out.println(en.countWays(5));
    System.out.println(en.countWays(6));
  }
}
