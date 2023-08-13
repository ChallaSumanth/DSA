class Solution {
    public boolean validPartition(int[] nums) {
        int len = nums.length;
        Boolean[] dp = new Boolean[len];
        return isValid(0, nums,len, dp);
    }
    private boolean isValid(int i, int[] nums, int len, Boolean[] dp)
    {
        if(i == len)
            return true;
        if(dp[i] != null)
            return dp[i];
        boolean one = false;
        boolean two = false;
        boolean three = false;
        if(i + 1 < len)
        {
            if(nums[i] == nums[i + 1])
                one = isValid(i + 2, nums, len, dp);
        }
        if(i + 2 < len)
        {
            if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
                two = isValid(i + 3, nums, len, dp);
            if(nums[i] == nums[i + 1] - 1 && nums[i + 1] + 1 == nums[i + 2])
                three = isValid(i + 3, nums, len, dp);
        }
           
        return dp[i] = one || two || three;
    }
}
//2.Tabulation
class Solution {
    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 2; i <= len; i++)
        {
            dp[i] |= nums[i - 1] == nums[i - 2] && dp[i - 2];
            dp[i] |= i > 2 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3];
            dp[i] |= i > 2 && nums[i - 1] == nums[i - 2] + 1 && nums[i - 2] == nums[i - 3] + 1 && dp[i - 3];
        }
        return dp[len];
    }
}
