class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i = n; i < 2*n; i++)
            nums[i] = (nums[i] * 1001) + nums[i - n];
        int index = 0;
        for(int i = n; i < 2*n; i++)
        {
            nums[index] = nums[i] % 1001;
            nums[index + 1] = nums[i] / 1001;
            index += 2;
        }
        return nums;
    }
}