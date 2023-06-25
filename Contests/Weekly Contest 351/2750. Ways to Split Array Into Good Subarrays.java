class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int len = nums.length;
        long ans = 1;
        int mod = (int)1e9 + 7;
        int i = 0;
        while(i < len && nums[i] == 0) i++;
        if(i >= len) return 0;
        long count = 0;
        while(i < len)
        {
            if(nums[i] == 1)
            {
                ans = (ans * (count + 1)) % mod;
                count = 0;
            }
            else
                count++;
            i++;
        }
        return (int)ans % mod;
    }
}