//Microsoft 26 Amazon 13 Apple 11 Facebook 10 Google 8 Adobe 3 LiveRamp 3 Zillow 2 Uber 2
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        while(rowStart <= rowEnd && colStart <= colEnd)
        {
                for(int i = colStart; i <= colEnd; i++)
                    ans.add(matrix[rowStart][i]);
                rowStart = rowStart + 1;
                for(int i = rowStart; i <= rowEnd; i++)
                    ans.add(matrix[i][colEnd]);
                colEnd = colEnd - 1;
            if(rowEnd >= rowStart)
            {
                for(int i = colEnd; i >= colStart; i--)
                    ans.add(matrix[rowEnd][i]);
                rowEnd = rowEnd - 1;
            }
            if(colEnd >= colStart)
            {
                for(int i = rowEnd; i>= rowStart; i--)
                    ans.add(matrix[i][colStart]);
                colStart = colStart + 1;
            }
        }
        return ans;
    }
}
