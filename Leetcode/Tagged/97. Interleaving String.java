//Amazon 4 Apple 4 Google 3 Uber 2 Bloomberg 2
//1.Recursion - tle
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3)
            return false;
        return solve(s1, s2, s3, len1, len2, len3, 0, 0);
    }
    private boolean solve(String s1, String s2, String s3, int len1, int len2, int len3, int i, int j)
    {
        if(i + j == len3)
            return true;
        if(i < len1 && s1.charAt(i) == s3.charAt(i + j))
            if(solve(s1, s2, s3, len1, len2, len3, i + 1, j))
                return true;
        if(j < len2 && s2.charAt(j) == s3.charAt(i + j))
            if(solve(s1, s2, s3, len1, len2, len3, i, j + 1))
                return true;
        return false;
    }
}
//2.Memorization - tle
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        return solve(s1, s2, s3, len1, len2, len3, 0, 0, dp);
    }
    private boolean solve(String s1, String s2, String s3, int len1, int len2, int len3, int i, int j, boolean[][] dp)
    {
        if(i + j == len3)
            return dp[i][j] = true;
        if(i < len1 && s1.charAt(i) == s3.charAt(i + j))
            if(solve(s1, s2, s3, len1, len2, len3, i + 1, j, dp))
                return dp[i][j] = true;
        if(j < len2 && s2.charAt(j) == s3.charAt(i + j))
            if(solve(s1, s2, s3, len1, len2, len3, i, j + 1, dp))
                return dp[i][j] = true;
        return dp[i][j] = false;
    }
}
//3.Tabulation
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
       for(int i = 0; i <= len1; i++)
       {
           for(int j = 0; j <= len2; j++)
           {
               if(i == 0 && j == 0)
                    dp[i][j] = true;
               else if(i == 0)
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
               else if(j == 0)
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
               else
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
                               (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
           }
       }
       return dp[len1][len2];
    }
}