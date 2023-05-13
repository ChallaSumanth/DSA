//1.recursion
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = (int) 1e9 + 7;
        int [] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        int ans = 0;
        for(int len = low; len <= high; len++)
            ans = (ans % mod + countLenGoodStrings(len, zero, one, mod, dp) % mod);
        return ans % mod;
    }
    private int countLenGoodStrings(int len, int zero, int one, int mod, int[] dp)
    {
        if(len == 0) return 1;
        if(len < 0) return 0;
        if(dp[len] != -1) return dp[len];
        
        return dp[len] = (countLenGoodStrings(len - zero, zero, one, mod, dp) % mod) +
                        (countLenGoodStrings(len - one, zero, one, mod, dp) % mod);
        
    }
}
//2.iterative dp
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = (int) 1e9 + 7;
        int [] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for(int len = 1; len <= high; len++)
        {
            if(len >= zero) dp[len] = dp[len - zero] % mod;

            if(len >= one) dp[len] = (dp[len] + dp[len - one]) % mod;

            if(len >= low) ans = (ans + dp[len]) % mod;

        }
        return ans;
    }
}
