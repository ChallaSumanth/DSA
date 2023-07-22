//Amazon 3
//1.Recursion - tle
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[] dx = new int[]{-1, -2, 1, 2, -2, 1, 2, -1};
        int[] dy = new int[]{-2, -1, 2, 1, 1, -2, -1, 2};
        return proba(n, k, row, column, dx, dy);
    }
    private double proba(int n, int k, int i, int j, int[] dx, int[] dy)
    {
        if(i >= n || j >= n || i < 0 || j < 0) return 0;
        if(k == 0) return 1;

        double probability = 0;
        for(int x = 0; x < 8; x++)
        {
            int nx = i + dx[x];
            int ny = j + dy[x];
            probability += 0.125 * proba(n, k - 1, nx, ny, dx, dy);
        }
        return probability;
    }
}
//2.Memorization
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[] dx = new int[]{-1, -2, 1, 2, -2, 1, 2, -1};
        int[] dy = new int[]{-2, -1, 2, 1, 1, -2, -1, 2};
        double[][][] dp = new double[n][n][k + 1];
        return proba(n, k, row, column, dx, dy, dp);
    }
    private double proba(int n, int k, int i, int j, int[] dx, int[] dy, double[][][] dp)
    {
        if(i >= n || j >= n || i < 0 || j < 0) return 0;
        if(k == 0) return 1;

        double probability = 0;
        if(dp[i][j][k] != 0) return dp[i][j][k];
        for(int x = 0; x < 8; x++)
        {
            int nx = i + dx[x];
            int ny = j + dy[x];
            probability += 0.125 * proba(n, k - 1, nx, ny, dx, dy, dp);
        }
        return dp[i][j][k] = probability;
    }
}