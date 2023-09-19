//1.
class Solution {
    public int findDuplicate(int[] nums) {
        for(int num : nums)
        {
            int idx = Math.abs(num);
            if(nums[idx] < 0)
                return idx;
            nums[idx] = -nums[idx];
        }
        return 1;
    }
}
//2.
class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[0] != nums[nums[0]])
        {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
    }
}