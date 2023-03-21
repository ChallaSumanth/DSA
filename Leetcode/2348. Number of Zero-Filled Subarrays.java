//1.
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++)
        {
            long count = 0 ;
            while(i < len && nums[i] == 0)
            {
                count++;
                ans += count;
                i++;
            }
        }
        return ans;
    }
}
//2.one pass
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int j = 0;
        for(int i = 0; i < len; i++)
        {
            if(nums[i] != 0)
                j = i + 1;
            ans += i - j + 1;
        }
        return ans;
    }
}