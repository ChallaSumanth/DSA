class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        Set<Integer> leftDiag = new HashSet<>();
        Set<Integer> rightDiag = new HashSet<>();
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                addLeftDiag(grid, i - 1, j - 1, row, col, leftDiag);
                addRightDiag(grid, i + 1, j + 1, row, col, rightDiag);
                
                res[i][j] = Math.abs(leftDiag.size() - rightDiag.size());
                
                leftDiag.clear();
                rightDiag.clear();
            }
        }
        return res;
    }
    private void addLeftDiag(int[][] grid, int i, int j, int row, int col, Set<Integer> leftDiag)
    {
        if(i < 0 || j < 0)
            return;
        leftDiag.add(grid[i][j]);
        addLeftDiag(grid, i - 1, j - 1, row, col, leftDiag);
    }
    private void addRightDiag(int[][] grid, int i, int j, int row, int col, Set<Integer> rightDiag)
    {
        if(i >= row || j >= col)
            return;
        rightDiag.add(grid[i][j]);
        addRightDiag(grid, i + 1, j + 1, row, col, rightDiag);
    }
}