//Amazon
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int len = nums.length;
        int minIndex = -1;
        int maxIndex = -1;
        int lastInvalidIndex = -1;
        long count = 0;
        for(int i = 0; i < len; i++)
        {
            if(nums[i] >= minK && nums[i] <= maxK)
            {
                minIndex = nums[i] == minK ? i : minIndex;
                maxIndex = nums[i] == maxK ? i : maxIndex;

                count += Math.max(0, Math.min(minIndex, maxIndex) - lastInvalidIndex);
            }
            else
            {
                lastInvalidIndex = i;
                minIndex = -1;
                maxIndex = -1;
            }
        }
        return count;
    }
}