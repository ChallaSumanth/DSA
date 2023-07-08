class Solution {
    public int alternatingSubarray(int[] nums) {
        int len = nums.length;
        int maxLen = -1;
        for(int i = 0; i < len; i++)
        {
           int num = 1;
           int prev = nums[i];
           for(int j = i + 1; j < len; j++)
           {
               if(nums[j] - prev == num)
               {
                   prev = nums[j];
                   num *= -1;
                   maxLen = Math.max(maxLen, j - i + 1);
               }
               else
                   break;
           }
        }
        return maxLen;
    }
}