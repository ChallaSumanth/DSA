//1.2pass
class Solution {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return true;
        int index = 0;
        for(int i = 1; i < len; i++)
        {
            if(nums[i - 1] <= nums[i])
            {
                index = i;
            }
            else
                break;
        }
        if(index == len - 1)
            return true;
        index = 0;
        for(int i = 1; i < len; i++)
        {
            if(nums[i - 1] >= nums[i])
            {
                index = i;
            }
            else
                break;
        }
        return index == len - 1;
    }
}
//1.pass
class Solution {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return true;
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for(int i = 1; i < len; i++)
        {
            if(nums[i - 1] < nums[i])
            {
                isDecreasing = false;
            }
            else if(nums[i - 1] > nums[i])
            {
                isIncreasing = false;
            }
            if (!isIncreasing && !isDecreasing)
                return false;
        }
        return true;
    }
}