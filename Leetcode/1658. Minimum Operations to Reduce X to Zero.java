class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        int maxLen = -1, currSum = 0;
        int len = nums.length;
        for(int l = 0, r = 0; r < len; r++)
        {
            currSum += nums[r];
            while(l <= r && currSum > sum - x)
                currSum -= nums[l++];
            if(currSum == sum - x)
                maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen == -1 ? -1 : len - maxLen;
    }
}