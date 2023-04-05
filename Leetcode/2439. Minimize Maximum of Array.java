class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefixSum = 0;
        int len = nums.length;
        long ans = 0;
        for(int i = 0; i < len; i++)
        {
            prefixSum += nums[i];
            ans = Math.max(ans, (prefixSum + i) / (i + 1)); //ceil(double(sum) / (i + 1))
        }
        return (int)ans;
    }
}
