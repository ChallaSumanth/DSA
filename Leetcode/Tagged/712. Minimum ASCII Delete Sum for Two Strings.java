//TripleByte 4 Activision 2
//1.recursion + memorization
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        return solve(s1, s2, m, n, dp);
    }
    private int solve(String s1, String s2, int m, int n, int[][] dp)
    {
        if(dp[m][n] != 0) return dp[m][n];
        if(m == 0)
        {
            int sum = 0;
            for(int i = 0; i < n; i++)
                sum += s2.charAt(i);
            return dp[m][n] = sum;
        }
        if(n == 0)
        {
            int sum = 0;
            for(int i = 0; i < m; i++)
                sum += s1.charAt(i);
            return dp[m][n] = sum;
        }
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = solve(s1, s2, m - 1, n - 1, dp);
        else
        {
            int deleteFromS1 = s1.charAt(m - 1) + solve(s1, s2, m - 1, n, dp);
            int deleteFromS2 = s2.charAt(n - 1) + solve(s1, s2, m, n - 1, dp);

            return dp[m][n] = Math.min(deleteFromS1 ,deleteFromS2);
        }
    }
}
//2.Tabulation
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(i == 0 || j == 0)
                {
                    int sum = 0;
                    for(int k = 1; k <= Math.max(i, j); k++)
                        sum += i == 0 ? s2.charAt(k - 1) : s1.charAt(k - 1);
                    dp[i][j] = sum;
                }
                else if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),
                                        dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}