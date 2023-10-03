class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(nums[i] == nums[j])
                    count++;
            }
        }
        return count;
    }
}
//2.
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for(int num : nums)
        {
            ans += count[num]++;
        }
        return ans;
    }
}