class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int [] temp = new int[len];
        mergeSort(0,len - 1,nums,temp);
        return nums;
    }
    private void mergeSort(int left, int right, int[] nums, int [] temp)
    {
        if(left < right)
        {
            int mid = (left + right) / 2;
            mergeSort(left, mid , nums, temp);
            mergeSort(mid + 1, right, nums, temp);
            merge(left, mid + 1, right, nums, temp);
        }
    }
    private void merge(int left, int mid, int right, int[] nums, int[] temp)
    {
        int i = left;
        int j = mid;
        int k = left;
        while(i <= mid -1 && j <= right)
        {
            if(nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else 
                temp[k++] = nums[j++];
        }
        while(i <= mid - 1)
            temp[k++] = nums[i++];
        while(j <= right)
            temp[k++] = nums[j++];
        for(i = left; i <= right; i++)
            nums[i] = temp[i];
    }
}