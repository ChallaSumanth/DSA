//Amazon 7 Microsoft 5 Google 4 Goldman Sachs 3 Oracle 3 Apple 3 Uber 2 Square 2
//1.Recursion
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return minPath(grid, m - 1, n - 1);
    }
    private int minPath(int[][] grid, int i, int j)
    {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int) 1e9;
        int up = grid[i][j] + minPath(grid, i - 1, j);
        int left = grid[i][j] + minPath(grid, i, j - 1);
        return Math.min(left, up);
    }
}
//2.Memorization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return minPath(grid, m - 1, n - 1, dp);
    }
    private int minPath(int[][] grid, int i, int j, int[][] dp)
    {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int) 1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + minPath(grid, i - 1, j, dp);
        int left = grid[i][j] + minPath(grid, i, j - 1, dp);
        return dp[i][j] = Math.min(left, up);
    }
}

//3.Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else
                {
                    int up = grid[i][j];
                    if(i > 0)
                        up += dp[i - 1][j];
                    else
                        up += (int) 1e9;
                    int left = grid[i][j];
                    if(j > 0)
                        left += dp[i][j - 1];
                    else
                        left += (int) 1e9;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
//4.Space optimizatiom
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for(int i = 0; i < m; i++)
        {
            int[] cur = new int[n];
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j == 0)
                {
                    cur[j] = grid[i][j];
                }
                else
                {
                    int left = grid[i][j];
                    if(j > 0)
                        left += cur[j - 1];
                    else
                        left += (int) 1e9;
                    int up = grid[i][j];
                    if(i > 0)
                        up += prev[j];
                    else
                        up += (int) 1e9;
                    cur[j] = Math.min(left, up);
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }
}

   