class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        int ans = 0;
        int val = 0;
        for(int j = 0; j < m; j++)
        {
            for(int i = 0; i < n; i++)
            {
                val = 0;
                if(i - 1 >= 0 && j - 1 >= 0  && grid[i - 1][j - 1] < grid[i][j] && (j == 1 || dp[i - 1][j - 1] > 0))
                    val = Math.max(val, dp[i - 1][j - 1] + 1);
                if(j - 1 >=0 && grid[i][j - 1] < grid[i][j] && (j == 1 || dp[i][j - 1] > 0))
                    val = Math.max(val, dp[i][j - 1] + 1);
                if(i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] < grid[i][j] && (j == 1 || dp[i + 1][j - 1] > 0))
                    val = Math.max(val, dp[i + 1][j - 1] + 1);
                dp[i][j] = val;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}