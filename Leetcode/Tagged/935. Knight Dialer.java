//Amazon Google
//1.memorization
class Solution {
    public int knightDialer(int n) {
        int[][] graph = new int[][]{
            {4, 6},
            {8, 6},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}};
        int mod = (int)1e9 + 7;
        int count = 0;
        int[][] dp = new int[n + 1][10];
        for(int i = 0; i < 10; i++)
            count = (count + solve(n - 1, i, graph, dp)) % mod;
        return count;
    }
    private int solve(int n, int cur, int[][] graph, int[][] dp)
    {
        if(n == 0)
            return 1;
        if(dp[n][cur] != 0)
            return dp[n][cur];
        int count = 0;
        for(int nextDigit : graph[cur])
            count = (count + solve(n - 1, nextDigit, graph, dp)) % (int) (1e9 + 7);
        return dp[n][cur] = count;
    }
}
//2.Tabulation
class Solution {
    public int knightDialer(int n) {
        int[][] graph = new int[][]{
            {4, 6},
            {8, 6},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}};
        int mod = (int)1e9 + 7;
        int count = 0;
        int[][] dp = new int[n][10];
        for(int i = 0; i < 10; i++)
           dp[0][i] = 1;
        for(int rem = 1; rem < n; rem++)
        {
            for(int digit = 0; digit < 10; digit++)
            {
                int ans = 0;
                for(int nextDigit : graph[digit])
                {
                    ans = (ans + dp[rem - 1][nextDigit]) % mod;
                }
                dp[rem][digit] = ans % mod;
            }
        }
        for(int i = 0; i < 10; i++)
            count = (count + dp[n - 1][i]) % mod;
        return count;
    }
   
}
