class Solution {
    public int numberOfWays(int n, int x) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        return solve(1, n, x, mod, dp);
    }
    private int solve(int i, int n, int x, int mod, int[][] dp)
    {
        if(n == 0)
            return 1;
        if(n < 0 || i > n)
            return 0;
        if(dp[i][n] != 0) return dp[i][n];
        int take = solve(i + 1, n - (int)Math.pow(i, x), x, mod, dp);
        int nottake = solve(i + 1, n, x, mod, dp);
        return dp[i][n] = (take  + nottake) % mod;
    }
}