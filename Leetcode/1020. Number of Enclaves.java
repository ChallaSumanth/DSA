//Google
class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(i == 0 || j == 0 || i == row - 1 || j == col - 1)
                    dfs(i, j, row, col, grid);
            }
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
                if(grid[i][j] == 1) ans++;
        }
        return ans;
    }
    private void dfs(int i, int j, int row, int col, int[][] grid)
    {
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) return;

        grid[i][j] = 0;

        dfs(i + 1, j, row, col, grid);
        dfs(i - 1, j, row, col, grid);
        dfs(i, j + 1, row, col, grid);
        dfs(i, j - 1, row, col, grid);
    }
}