//https://practice.geeksforgeeks.org/problems/96161dfced02d544fc70c71d09b7a616fe726085/1
//uber
//1.recursion
class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int mod = (int)1e9+7;
        int [][] dp = new int[n][m];
        for(int [] arr : dp)
            Arrays.fill(arr,-1);
        return dfs(grid,0,0,n,m,dp,mod);
    }
    private static int dfs(int[][] grid,int i, int j, int n,int m,int [][] dp,int mod)
    {
        if(i >= n || i < 0 || j >= m || j < 0 || grid[i][j] == 0) return 0;
        
        if(i == n - 1 && j == m - 1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = (dfs(grid,i + 1, j, n, m,dp,mod) % mod + dfs(grid, i, j + 1,n, m,dp,mod) % mod)%mod;
    }
};

//2.Tabulation
class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        if(grid[0][0] == 0 || grid[n - 1][m - 1] == 0) return 0;
        int mod = (int)1e9+7;
        int [][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++)
        {
            if(grid[i][0] == 1)
            dp[i][0] = dp[i - 1][0];
        }
        for(int j = 1; j < m; j++)
        {
            if(grid[0][j] == 1)
            dp[0][j] = dp[0][j - 1];
        }
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
};