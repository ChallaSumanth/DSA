//Facebook 2
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int negCount = 0;
        for(int[] row : grid)
        {
            for(int i = 0; i < n; i++)
            {
                if(row[i] < 0)
                {
                    negCount += n - i;
                    break;
                }
            }
        }
        return negCount;
    }
}
//optimal Tc:O(m + n)
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int negCount = 0;
        int i = 0;  
        int j = n - 1;
        while(i < m && j >= 0)
        {
            if(grid[i][j] < 0)
            {
                negCount += m - i;
                j--;
            }
            else
                i++;
        }
        return negCount;
    }
}