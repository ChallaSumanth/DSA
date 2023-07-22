class Solution {
    public long maxScore(int[] nums, int x) {
        int len = nums.length;
        long[][] dp = new long[len][2];
        for(long[] arr : dp)
            Arrays.fill(arr, -1);
        return nums[0] + solve(1, nums[0] % 2, x, nums, dp, len);
    }
    private long solve(int i, int cur, int x, int[] nums, long[][] dp, int len)
    {
        if(i >= len)
            return 0;
        if(dp[i][cur] != -1) return dp[i][cur];
        long curAns = Integer.MIN_VALUE;
        if(nums[i] % 2 == cur)
            curAns = Math.max(curAns, nums[i] + solve(i + 1, cur, x, nums, dp, len));
        else
        {
            curAns = Math.max(curAns, solve(i + 1, cur, x, nums, dp, len));
            curAns = Math.max(curAns, nums[i] - x + solve(i + 1, 1 - cur, x, nums, dp, len));
        }
        return dp[i][cur] = curAns;
    }
}