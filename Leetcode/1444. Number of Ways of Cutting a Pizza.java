class Solution {
    public int ways(String[] pizza, int k) {
        int row = pizza.length;
        int col = pizza[0].length();
        Integer[][][] dp = new Integer[k][row][col];
        int[][] preSum = new int[row + 1][col + 1];
        for(int r = row - 1; r >= 0; r--)
        {
            for(int c = col - 1; c >= 0; c--)
            {
                preSum[r][c] = preSum[r + 1][c] + preSum[r][c + 1] - preSum[r + 1][c + 1] + (pizza[r].charAt(c) == 'A' ? 1 : 0);
            }
        }
        return dfs(row, col, k - 1, 0 , 0, dp, preSum);
    }
    private int dfs(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] preSum)
    {
        if(preSum[r][c] == 0) return 0;

        if(k == 0) return 1;

        if(dp[k][r][c] != null) return dp[k][r][c];

        int ans = 0;

        for(int nr = r + 1; nr < m; nr++)
            if(preSum[r][c] - preSum[nr][c] > 0) 
                ans = (ans + dfs(m, n, k - 1, nr, c, dp, preSum)) %  1000000007;
        for(int nc = c + 1; nc < n; nc++)
            if(preSum[r][c] - preSum[r][nc] > 0)
                ans = (ans +  dfs(m, n, k - 1, r, nc, dp, preSum)) %  1000000007;
        
        return dp[k][r][c] = ans;
    }
}