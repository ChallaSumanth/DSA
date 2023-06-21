class Solution {
    public long minCost(int[] nums, int[] cost) {
        int lo = nums[0];
        int hi = nums[0];
        int len = nums.length;
        for(int num : nums)
        {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }
        long ans = 0;
        while(lo < hi)
        {
            int mid = (lo + hi) >> 1;
            long res1 = findCost(nums, cost, mid, len);
            long res2 = findCost(nums, cost, mid + 1, len);
            ans = Math.min(res1, res2);
            if(res1 < res2)
            {
                hi = mid;
            }
            else
                lo = mid + 1;
        }
        return ans;
    }

    private long findCost(int[] nums, int[] cost, int x, int len)
    {
        long ans = 0L;
        for(int i = 0; i < len; i++)
        {
            ans += 1L * Math.abs(nums[i] - x) * cost[i];
        }
        return ans;
    }
}