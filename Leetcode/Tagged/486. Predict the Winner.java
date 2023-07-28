//Google 2 Snapchat 2
//1.recusion
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1) >= 0;
    }
    private int solve(int[] nums, int start, int end)
    {
        if(start == end)
            return nums[start];
        int takeStart = nums[start] - solve(nums, start + 1, end);
        int takeEnd = nums[end] - solve(nums, start, end - 1);
        return Math.max(takeStart, takeEnd);
    }
}
//2.Memorization
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        return solve(nums, 0, len - 1, new int[len][len]) >= 0;
    }
    private int solve(int[] nums, int start, int end, int[][] dp) 
    {
        if(start == end)
            return nums[start];
        if(dp[start][end] != 0) return dp[start][end];
        int takeStart = nums[start] - solve(nums, start + 1, end, dp);
        int takeEnd = nums[end] - solve(nums, start, end - 1, dp);
        return dp[start][end] = Math.max(takeStart, takeEnd);
    }
}