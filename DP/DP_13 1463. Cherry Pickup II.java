//1.Recurision TC : O(3 ^ N * 3 ^ N) SC : O(N) 
class Solution {
    private int maxSum(int i, int j1, int j2, int[][] grid, int n, int m)
    {
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e9;
        if(i == n - 1)
        {
            if(j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for(int dj1 = -1; dj1 <= 1; dj1++)
        {
            for(int dj2 = -1; dj2 <= 1; dj2++)
            {
                int value = 0;
                if(j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                value += maxSum(i + 1, j1 + dj1, j2 + dj2, grid, n, m);
                max = Math.max(value, max);
            }
        }
        return max;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return maxSum(0, 0, m - 1, grid, n, m);
    }
}
//2.Memorization TC : O(N * M * M) * 9 + O(N), SC : O(N * M * M)
class Solution {
    private int maxSum(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp)
    {
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e9;
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        if(i == n - 1)
        {
            if(j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for(int dj1 = -1; dj1 <= 1; dj1++)
        {
            for(int dj2 = -1; dj2 <= 1; dj2++)
            {
                int value = 0;
                if(j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                value += maxSum(i + 1, j1 + dj1, j2 + dj2, grid, n, m, dp);
                max = Math.max(value, max);
            }
        }
        return dp[i][j1][j2] = max;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] mat : dp)
        {
            for(int[] row : mat)
                Arrays.fill(row, -1);
        }
        return maxSum(0, 0, m - 1, grid, n, m, dp);
    }
}
//3.Tabulation TC : O(N * M * M) * 9 , SC : O(N * M * M)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int j1 = 0; j1 < m; j1++)
        {
            for(int j2 = 0; j2 < m; j2++)
            {
                if(j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for(int i = n - 2; i >= 0; i--)
        {
            for(int j1 = 0; j1 < m; j1++)
            {
                for(int j2 = 0; j2 < m; j2++)
                {
                    int max = 0;
                    for(int dj1 = -1; dj1 <= 1; dj1++)
                    {
                        for(int dj2 = -1; dj2 <= 1; dj2++)
                        {
                            int value = 0;
                            if(j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m)
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            else
                                value += (int) -1e9;
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}
//4.Space Optimization TC : O(N * M * M) * 9 , SC : O(M * M)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];
        for(int j1 = 0; j1 < m; j1++)
        {
            for(int j2 = 0; j2 < m; j2++)
            {
                if(j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        for(int i = n - 2; i >= 0; i--)
        {
            for(int j1 = 0; j1 < m; j1++)
            {
                for(int j2 = 0; j2 < m; j2++)
                {
                    int max = 0;
                    for(int dj1 = -1; dj1 <= 1; dj1++)
                    {
                        for(int dj2 = -1; dj2 <= 1; dj2++)
                        {
                            int value = 0;
                            if(j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m)
                                value += front[j1 + dj1][j2 + dj2];
                            else
                                value += (int) -1e9;
                            max = Math.max(max, value);
                        }
                    }
                    cur[j1][j2] = max;
                }
            }
            //front = cur;
            for (int a = 0; a < m; a++) 
                front[a] = (int[])(cur[a].clone());
        }
        return front[0][m - 1];
    }
}