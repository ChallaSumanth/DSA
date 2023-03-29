class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        int[][] dp = new int[len + 1][len + 1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return solve(satisfaction, 0, 0, dp);
    }
    private int solve(int[] satisfaction, int index, int time, int[][] dp)
    {
        if(index == satisfaction.length) return 0;

        if(dp[index][time] != -1) return dp[index][time];
        int include = satisfaction[index] * (time + 1) + solve(satisfaction, index + 1, time + 1, dp);

        int exclude = solve(satisfaction, index + 1, time, dp);

        return dp[index][time] = Math.max(include, exclude);
    }
}