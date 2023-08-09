class Solution {
    public int minimizeMax(int[] nums, int p) {
        int len = nums.length;
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[len - 1] - nums[0];
        int ans = 0;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(canFormPairs(nums, len, mid, p))
            {
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        return ans;
    }
    private boolean canFormPairs(int[] nums, int len, int maxDiff, int p)
    {
        for(int i = 1; i < len; i++)
        {
            if(nums[i] - nums[i - 1] <= maxDiff)
            {
                p--;
                i++;
            }
            if(p <= 0)
                return true;
        }
        return p <= 0;
    }
}