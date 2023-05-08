class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        int i = 0, j = 0, k = mat[0].length - 1, l = 0;
        while(k != -1)
        {
            if(i == j)
                sum += mat[i][j] + mat[l][k];
                i++; j++; l++; k--;
        }
        if(len % 2 != 0)
            sum -= mat[(int) len / 2][(int) len / 2];
        return sum;
    }
}