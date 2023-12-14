class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [] row0 = new int[m];
        int [] row1 = new int[m];
        int [] col0 = new int[n];
        int [] col1 = new int[n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    row1[i]++;
                    col1[j]++;
                }
                else
                {
                    row0[i]++;
                    col0[j]++;
                }
            }
        }
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ans[i][j] = row1[i] + col1[j] - row0[i] - col0[j];
            }
        }
        return ans;
    }
}