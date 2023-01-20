class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int curMax = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMin = 0;
        for(int ele : nums)
        {
            curMax = Math.max(curMax + ele , ele);
            maxSum = Math.max(maxSum,curMax);

            curMin = Math.min(curMin + ele,ele);
            minSum = Math.min(minSum,curMin);

            totalSum += ele;
        }
        return maxSum > 0 ? Math.max(maxSum , totalSum - minSum) : maxSum;
    }
}