
class Solution {

  public List<Integer> findMDI(String s1, String s2) {
    int c1 = findLCSLength(s1, s2);
    int deletions = s1.length() - c1;
    int insertions = s2.length() - c1;
    List<Integer> result = new ArrayList<>();
    result.add(deletions);
    result.add(insertions);
    return result;
  }
  
  private int findLCSLength(String s1, String s2) {
    int[][] dp = new int[s1.length()+1][s2.length()+1];
    int maxLength = 0;
    for(int i=1; i <= s1.length(); i++) {
      for(int j=1; j <= s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1))
          dp[i][j] = 1 + dp[i-1][j-1];
        else
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        
        maxLength = Math.max(maxLength, dp[i][j]);
      }
    }
    return maxLength;
  }
  
  public static void main(String[] args) {
    Solution mdi = new Solution();
    List<Integer> res;
    res = mdi.findMDI("abc", "fbc");
    System.out.println("1 -> Number of Deletions: "+ res.get(0));
    System.out.println("1 -> Number of Insertions: "+ res.get(0));
    res = mdi.findMDI("abdca", "cbda");
    System.out.println("2 -> Number of Deletions: "+ res.get(0));
    System.out.println("2 -> Number of Insertions: "+ res.get(0));
    res = mdi.findMDI("passport", "ppsspt");
    System.out.println("3 -> Number of Deletions: "+ res.get(0));
    System.out.println("3 -> Number of Insertions: "+ res.get(0));

  }
}
