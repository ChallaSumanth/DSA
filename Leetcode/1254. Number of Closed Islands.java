//Google
class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == 0)
                {
                    if(dfs(i, j, row, col, grid))
                        ans++;
                }
            }
        }
        return ans;
    }
    private boolean dfs(int i, int j, int row, int col, int[][] grid)
    {
        if(i < 0 || i >= row || j < 0 || j >= col) return false;

        if(grid[i][j] == 1) return true;
        grid[i][j] = 1;

        boolean d1 = dfs(i+1, j, row, col, grid);
        boolean d2 = dfs(i-1, j, row, col, grid);
        boolean d3 = dfs(i, j+1, row, col, grid);
        boolean d4 = dfs(i, j-1, row, col, grid);

        return d1 && d2 && d3 && d4;
    }

}