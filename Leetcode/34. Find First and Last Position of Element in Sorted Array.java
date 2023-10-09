class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int leftIndex = binarySearch(nums, lo, hi, target, true);
        int rightIndex = binarySearch(nums, lo, hi, target, false);
        if(leftIndex <= rightIndex)
            return new int[]{leftIndex, rightIndex};
        return new int[]{-1, -1};
    }
    private int binarySearch(int[] nums, int lo, int hi, int target, boolean findLeft)
    {
        int index = -1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(nums[mid] == target)
            {
                index = mid;
                if(findLeft)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else if(nums[mid] < target)
            {
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return index;
    }
}