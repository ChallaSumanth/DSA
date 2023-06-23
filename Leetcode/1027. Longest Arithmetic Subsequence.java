//1.Recursion
class Solution {
    private int longestLen(int index, int[] nums, int diff)
    {
        if(index < 0)
            return 0;
        int ans = 0;
        for(int j = index - 1; j >= 0; j--)
        {
            if(nums[index] - nums[j] == diff)
            {
                ans = Math.max(ans, 1 + longestLen(j, nums, diff));
            }
        }
        return ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        if(len <= 2)
            return len;
        int ans = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                ans = Math.max(ans, 2 + longestLen(i, nums, nums[j] - nums[i]));
            }
        }
        return ans;
    }
}
//2.Memorization
class Solution {
    private int longestLen(int index, int[] nums, int diff, int[][] dp)
    {
        if(index < 0)
            return 0;
        int ans = 0;
        if(dp[index][diff + 500] != -1)
            return dp[index][diff + 500];
        for(int j = index - 1; j >= 0; j--)
        {
            if(nums[index] - nums[j] == diff)
            {
                ans = Math.max(ans, 1 + longestLen(j, nums, diff, dp));
            }
        }
        return dp[index][diff + 500] = ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        if(len <= 2)
            return len;
        int ans = 0;
        int[][] dp = new int[len + 1][1002];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                ans = Math.max(ans, 2 + longestLen(i, nums, nums[j] - nums[i], dp));
            }
        }
        return ans;
    }
}
//3.Tabulation
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        if(len <= 2)
            return len;
        int ans = 0;
        int[][] dp = new int[len + 1][1002];
        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                int diff = nums[i] - nums[j];
                int count = 1;
                if(dp[j][diff + 500] != 0)
                    count = dp[j][diff + 500];
                dp[i][diff + 500] = 1 + count;
                ans = Math.max(ans, dp[i][diff + 500]);
            }
        }
        return ans;
    }
}