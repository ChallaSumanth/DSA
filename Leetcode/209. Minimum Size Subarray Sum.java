// Facebook 8 Amazon 6 Microsoft 4 Bloomberg 2 Goldman Sachs 2 Google 2 Apple 2 Arcesium 2
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int minSize = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0, start = 0;
        while(i < len)
        {
            sum += nums[i++];
            while(sum >= target)
            {
                minSize = Math.min(minSize, i - start);
                sum -= nums[start++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
