//intuit
class Solution {
    long[] countZero(int N, int K, int[][] arr){
        // code here
        long total = N * N;
        int rowCount = 0;
        int colCount = 0;
        long [] ans = new long[K];
        int [] rowVisited = new int[N];
        int [] colVisited = new int[N];
        for(int i = 0; i < K; i++)
        {
            int row = arr[i][0] - 1;
            int col = arr[i][1] - 1;
            if(rowVisited[row] == 0)
            {
                rowVisited[row] = 1;
                colCount++;
                total = total - N + rowCount;
            }
            if(colVisited[col] == 0)
            {
                colVisited[col] = 1;
                rowCount++;
                total = total - N + colCount;
            }
            ans[i] = total;
        }
        return ans;
    }
}