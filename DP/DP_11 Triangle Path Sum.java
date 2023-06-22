//https://practice.geeksforgeeks.org/problems/triangle-path-sum/1?page=1&sortBy=newest&query=page1sortBynewest
//1.Recursion
class Solution {
    private static int minPathSum(int i, int j, ArrayList<ArrayList<Integer> >grid, int n)
    {
        if(i == n - 1)
            return grid.get(i).get(j);
        
        int down = grid.get(i).get(j) + minPathSum(i + 1, j, grid, n);
        int diag = grid.get(i).get(j) + minPathSum(i + 1, j + 1, grid, n);
        
        return Math.min(down, diag);
    }
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        return minPathSum(0, 0, grid, n);
    }
}
//2.Memorization
class Solution {
    private static int minPathSum(int i, int j, ArrayList<ArrayList<Integer> >grid, int n, int[][] dp)
    {
        if(i == n - 1)
            return grid.get(i).get(j);
        if(dp[i][j] != - 1) return dp[i][j];
        int down = grid.get(i).get(j) + minPathSum(i + 1, j, grid, n, dp);
        int diag = grid.get(i).get(j) + minPathSum(i + 1, j + 1, grid, n, dp);
        
        return dp[i][j] = Math.min(down, diag);
    }
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        int[][] dp = new int[n][n];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return minPathSum(0, 0, grid, n, dp);
    }
}
//3.Tabulation
class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        int[][] dp = new int[n][n];
        for(int i = n - 1; i >= 0; i--)
            dp[n - 1][i] = grid.get(n - 1).get(i);
        for(int i = n - 2; i >= 0; i--)
        {
            for(int j = i; j >= 0; j--)
            {
                int down = grid.get(i).get(j) + dp[i + 1][j];
                int diag = grid.get(i).get(j) + dp[i + 1][j + 1];
                
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
//4.Space Optimization
class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        int[] front = new int[n];
        for(int i = n - 1; i >= 0; i--)
            front[i] = grid.get(n - 1).get(i);
        for(int i = n - 2; i >= 0; i--)
        {
            int[] cur = new int[n];
            for(int j = i; j >= 0; j--)
            {
                int down = grid.get(i).get(j) + front[j];
                int diag = grid.get(i).get(j) + front[j + 1];
                
                cur[j] = Math.min(down, diag);
            }
            front = cur;
        }
        return front[0];
    }
}