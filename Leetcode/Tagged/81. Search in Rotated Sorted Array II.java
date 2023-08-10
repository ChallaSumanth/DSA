//Amazon 5 LinkedIn 4 Adobe 3 Facebook 2
class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(nums[mid] == target)
                return true;
            if(nums[lo] == nums[mid] && nums[mid] == nums[hi])
            {
                lo++;
                hi--;
            }
            else if(nums[lo] <= nums[mid])
            {
                if(nums[lo] <= target && target <= nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else if(nums[mid] <= nums[hi])
            {
                if(nums[mid] <= target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return false;
    }
}