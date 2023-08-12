//Cruise Automation 9 Facebook 8 Amazon 7 Qualtrics 4 Google 3 Cisco 3 Microsoft 2 Oracle 2
//1.Memorization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(m - 1, n - 1, obstacleGrid, dp);
    }
    private int solve(int i, int j, int [][] obstacleGrid, int[][] dp)
    {
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int left = solve(i, j - 1, obstacleGrid, dp);
        int up = solve(i - 1, j, obstacleGrid, dp);
        return dp[i][j] = left + up;
    }
}
//2.Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1) 
                    dp[i][j] = 0;
                else if(i == 0 && j == 0)
                    dp[i][j] = 1;
                else
                {
                    int up = 0, left = 0;
                    if(j > 0) left = dp[i][j - 1];
                    if(i > 0) up = dp[i - 1][j];

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
//3.space optimization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        for(int i = 0; i < m; i++)
        {
            int[] cur = new int[n];
            for(int j = 0; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1) 
                    cur[j] = 0;
                else if(i == 0 && j == 0)
                    cur[j] = 1;
                else
                {
                    int up = 0, left = 0;
                    if(j > 0) left = cur[j - 1];
                    if(i > 0) up = prev[j];

                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }
}