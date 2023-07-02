//1.
class Solution {
    public int minimizeArrayValue(int[] nums) {
        int lo = 0;
        int hi = 0;
        for(int num : nums)
            hi = Math.max(hi, num);
        while(lo < hi)
        {
            int mid = (lo + hi) >> 1;
            if(isValid(mid, nums))
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
    private boolean isValid(int x, int[] nums)
    {
        long sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(sum > (long) x * (i + 1)) return false;
        }
        return true;
    }
}

//2.optimal
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
