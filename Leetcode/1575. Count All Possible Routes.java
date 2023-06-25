class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int len = locations.length;
        int[][] dp = new int[len][fuel + 1];
        int mod = (int)1e9+7;
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return countRts(locations,start, finish, fuel, len, dp, mod);
    }
    private int countRts(int[] locations, int start, int finish, int fuel, int len, int[][] dp, int mod)
    {
        if(fuel < 0)
            return 0;
        if(dp[start][fuel] != -1) return dp[start][fuel];
        int ans = 0;
        if(start == finish)
            ans++;
        for(int i = 0; i < len; i++)
        {
            if(i == start || Math.abs(locations[start] - locations[i]) > fuel) continue;

            ans += countRts(locations, i, finish, fuel -  Math.abs(locations[start] - locations[i]), len, dp, mod) % mod;
            ans %= mod;
        }
        return dp[start][fuel] = ans % mod;
    }
}