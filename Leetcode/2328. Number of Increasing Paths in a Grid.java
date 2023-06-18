class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{1, -1, 0,  0};
        int[] dy = new int[]{0,  0, 1, -1};
        long [][] dp = new long[m][n];
        long res = 0;
        int mod = (int) 1e9 + 7;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                res = (res + dfs(grid, i, j, m, n, dx, dy, dp, mod)) % mod;
            }
        }
        return (int)res;
    }
    private long dfs(int[][] grid, int i, int j, int m, int n, int[] dx, int[] dy, long[][] dp, int mod)
    {
        long res = 1;
        if(dp[i][j] != 0)
            return dp[i][j];
        for(int k = 0; k < 4; k++)
        {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[i][j] < grid[nx][ny])
            {
               res = (res + dfs(grid, nx, ny, m, n, dx, dy, dp, mod)) % mod;
            }
        }
        return dp[i][j] = res;
    }
}