class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums;
        int i = -1;
        int j = 0;
        while(j < len)
        {
           if(nums[j] % 2 == 0)
           {
               i += 1;
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
           }
           j++;
        }
        return nums;
    }
}