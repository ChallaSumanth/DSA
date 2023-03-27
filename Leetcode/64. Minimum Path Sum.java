//1.recursion(tle)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid, m - 1, n - 1);
    }
    private int solve(int[][] grid, int row, int col)
    {
        if(row == 0 && col == 0) return grid[row][col];
        if(row == 0) return grid[row][col] + solve(grid, row, col - 1);
        if(col == 0) return grid[row][col] + solve(grid, row - 1, col);
        return grid[row][col] + Math.min(solve(grid, row, col - 1), solve(grid, row - 1, col));
    }
}
//2.memorization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int [] arr : dp)
            Arrays.fill(arr, -1);
        return solve(grid, m - 1, n - 1, dp);
    }
    private int solve(int[][] grid, int row, int col, int[][] dp)
    {
        if(dp[row][col] != -1) return dp[row][col];
        if(row == 0 && col == 0) return grid[row][col];
        if(row == 0) return grid[row][col] + solve(grid, row, col - 1, dp);
        if(col == 0) return grid[row][col] + solve(grid, row - 1, col, dp);
        return dp[row][col] = grid[row][col] + Math.min(solve(grid, row, col - 1, dp), solve(grid, row - 1, col, dp));
    }
}
//3.tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++)
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        for(int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
