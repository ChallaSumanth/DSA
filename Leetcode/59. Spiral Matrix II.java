// tiktok 6 Apple 4 Amazon 2
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] ans = new int[n][n];
        int rowStart = 0, colStart = 0;
        int rowEnd = n - 1, colEnd = n - 1;
        int num = 1;
        while(rowStart <= rowEnd && colStart <= colEnd)
        {
            for(int i = colStart; i <= colEnd; i++)
                ans[rowStart][i] = num++;
            rowStart = rowStart + 1;
            for(int i = rowStart; i <= rowEnd; i++)
                ans[i][colEnd] = num++;
            colEnd = colEnd - 1;
            if(rowStart <= rowEnd)
            {
                for(int i = colEnd; i >= colStart; i--)
                    ans[rowEnd][i] = num++;
                rowEnd = rowEnd - 1;
            }
            if(colStart <= colEnd)
            {
                for(int i = rowEnd; i >= rowStart; i--)
                    ans[i][colStart] = num++;
                colStart = colStart + 1;
            }
        }
        return ans;
    }
}