class Solution {
    public int maxScore(int[] nums) {
        int m = nums.length;
        int n = m / 2;
        int [] dp = new int[1<<14];
        Arrays.fill(dp, -1);
        return maximumScore(nums, 1, 0, dp, m, n);
    }
    private int maximumScore(int [] nums, int opr, int mask, int[] dp, int m, int n)
    {
        if(opr > n) return 0;
        if(dp[mask] != -1) return dp[mask];

        for(int i = 0; i < m; i++)
        {
            if((mask & (1 << i)) != 0) continue;
            for(int j = i + 1; j < m; j++)
            {
                if((mask & (1 << j)) != 0) continue;

                int newMask = (1 << i) | (1 << j) | mask;

                int score = opr * __gcd(nums[i], nums[j]) + maximumScore(nums, opr+1, newMask, dp, m, n);

                dp[mask] = Math.max(dp[mask], score);
            }
        }
        return dp[mask];
    }
    private int __gcd(int a, int b)
    {
        if(a == 0) return b;

        return __gcd(b % a, a);
    }
}