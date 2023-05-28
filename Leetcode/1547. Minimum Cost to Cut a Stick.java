class Solution {
    private int minCost(int start_stick, int end_stick, int[] cuts, int left, int right, int[][] dp)
    {
        if(left > right) return 0;
        
        if(dp[left][right] != -1) return dp[left][right];
        int min_cost = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++)
        {
            int left_cost = minCost(start_stick, cuts[i], cuts, left, i - 1, dp);
            int right_cost = minCost(cuts[i], end_stick, cuts, i + 1, right, dp);
            int cur_cost = end_stick - start_stick + left_cost + right_cost;
            min_cost = Math.min(min_cost, cur_cost);
        }
        return dp[left][right] = min_cost;
    }
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[][] dp = new int[101][101];
        for(int [] d : dp)
            Arrays.fill(d,-1);
        Arrays.sort(cuts);
        return minCost(0, n, cuts, 0, len - 1, dp);
    }
}