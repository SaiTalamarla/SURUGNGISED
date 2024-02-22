
class Solution {

  public Boolean findSI(String m, String n, String p) {
    // dp[mIndex][nIndex] will be storing the result of string interleaving
    // up to p[0..mIndex+nIndex-1]
    boolean[][] dp = new boolean[m.length()+1][n.length()+1];

    // make sure if lengths of the strings add up
    if(m.length() + n.length() != p.length())
      return false;

    for(int mIndex=0; mIndex<=m.length(); mIndex++) {
      for(int nIndex=0; nIndex<=n.length(); nIndex++) {
        // if 'm' and 'n' are empty, then 'p' must have been empty too.
        if(mIndex==0 && nIndex==0)
          dp[mIndex][nIndex] = true;
        // if 'm' is empty, we need to check the interleaving with 'n' only
        else if (mIndex==0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
          dp[mIndex][nIndex] = dp[mIndex][nIndex-1];
        // if 'n' is empty, we need to check the interleaving with 'm' only
        else if (nIndex==0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
          dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
        else {
          // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
          if(mIndex > 0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
            dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
          // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
          // note the '|=', this is required when we have common letters
          if(nIndex > 0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
            dp[mIndex][nIndex] |= dp[mIndex][nIndex-1];
        }
      }
    }
    return dp[m.length()][n.length()];
  }

  public static void main(String[] args) {
    Solution si = new Solution();
    System.out.println(si.findSI("abd", "cef", "abcdef"));
    System.out.println(si.findSI("abd", "cef", "adcbef"));
    System.out.println(si.findSI("abc", "def", "abdccf"));
    System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
  }
}
