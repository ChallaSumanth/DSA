class Solution {
    public long maxStrength(int[] nums) {
        long res = 1;
        Arrays.sort(nums);
        int len = nums.length;
        boolean flag = false;
        for(int i = 0; i + 1 < len && nums[i + 1] < 0; i++)
        {
            res *= (long) nums[i] * nums[i + 1];
            i++;
            flag = true;
        }
        for(int i = len - 1; i >= 0 && nums[i] > 0; i--)
        {
            res *= nums[i];
            flag = true;
        }
        if(flag) return res;
        for(int num : nums)
            if(num == 0) return 0;
        return nums[0];
    }
}