//https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1
//1.Recursion TC : O(3 ^ N) SC : O(N)
class Solution{
    private static int maximumPathSum(int i, int j, int[][] Matrix, int N)
    {
        if(j < 0 || j >= N) return (int)-1e9;
        if(i == 0)
            return Matrix[i][j];
        int up = Matrix[i][j] + maximumPathSum(i - 1, j, Matrix, N);
        int leftUp = Matrix[i][j] + maximumPathSum(i - 1, j - 1, Matrix, N);
        int rightUp = Matrix[i][j] + maximumPathSum(i - 1, j + 1, Matrix, N);
        
        return Math.max(leftUp, Math.max(up, rightUp));
    }
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++)
            max = Math.max(max, maximumPathSum(N - 1, i, Matrix, N));
        return max;
    }
}
//2.Memorization TC : O(N * N) SC : O(N * N) + O(N)
class Solution{
    private static int maximumPathSum(int i, int j, int[][] Matrix, int N, int[][] dp)
    {
        if(j < 0 || j >= N) return (int)-1e9;
        if(i == 0)
            return Matrix[i][j];
        if(dp[i][j] != -1)
            return dp[i][j];
        int up = Matrix[i][j] + maximumPathSum(i - 1, j, Matrix, N, dp);
        int leftUp = Matrix[i][j] + maximumPathSum(i - 1, j - 1, Matrix, N, dp);
        int rightUp = Matrix[i][j] + maximumPathSum(i - 1, j + 1, Matrix, N, dp);
        
        return dp[i][j] = Math.max(leftUp, Math.max(up, rightUp));
    }
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[N][N];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        for(int i = 0; i < N; i++)
            max = Math.max(max, maximumPathSum(N - 1, i, Matrix, N, dp));
        return max;
    }
}
//3.Tabulation TC : O(N * N) SC : O(N * N)
class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++)
            dp[0][i] = Matrix[0][i];
        for(int i = 1; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                int leftUp = Matrix[i][j];
                if(j - 1 >= 0)
                    leftUp += dp[i - 1][j - 1];
                else
                    leftUp += (int) -1e9;
                int up = Matrix[i][j] + dp[i - 1][j];
                int rightUp = Matrix[i][j];
                if(j + 1 < N)
                    rightUp += dp[i - 1][j + 1];
                else
                    rightUp += (int) -1e9;
                dp[i][j] = Math.max(leftUp, Math.max(up, rightUp));
            }
        }
        for(int i = 0; i < N; i++)
            max = Math.max(max, dp[N - 1][i]);
        return max;
    }
}
//4.Space Optimization TC : O(N * N) SC : O(N)
class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max = Integer.MIN_VALUE;
        int[] prev = new int[N];
        for(int i = 0; i < N; i++)
            prev[i] = Matrix[0][i];
        for(int i = 1; i < N; i++)
        {
            int[] cur = new int[N];
            for(int j = 0; j < N; j++)
            {
                int leftUp = Matrix[i][j];
                if(j - 1 >= 0)
                    leftUp += prev[j - 1];
                else
                    leftUp += (int) -1e9;
                int up = Matrix[i][j] + prev[j];
                int rightUp = Matrix[i][j];
                if(j + 1 < N)
                    rightUp += prev[j + 1];
                else
                    rightUp += (int) -1e9;
                cur[j] = Math.max(leftUp, Math.max(up, rightUp));
            }
            prev = cur;
        }
        for(int i = 0; i < N; i++)
            max = Math.max(max, prev[i]);
        return max;
    }
} 