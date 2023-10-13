//1.recursion - tle
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        return Math.min(minCost(0, len, cost), minCost(1, len, cost));
    }
    private int minCost(int index, int len, int[] cost)
    {
        if(index >= len)
            return 0;
        int take = cost[index] + Math.min(minCost(index + 1, len, cost),
        minCost(index + 2, len, cost));
        return take;
    }
}
//2.Memorization
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        return Math.min(minCost(0, len, cost, dp), minCost(1, len, cost, dp));
    }
    private int minCost(int index, int len, int[] cost, int[] dp)
    {
        if(index >= len)
            return 0;
        if(dp[index] != 0)
            return dp[index];
        int take = cost[index] + Math.min(minCost(index + 1, len, cost, dp),
        minCost(index + 2, len, cost, dp));
        return dp[index] = take;
    }
}
//3.Tabulation
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 2];
        for(int i = len - 1; i >= 0; i--)
        {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
//4.space optimization
public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int first = cost[0];
    int second = cost[1];
    if (n <= 2) return Math.min(first, second);
    for (int i = 2; i < n; i++) {
        int curr = cost[i] + Math.min(first, second);
        first = second;
        second = curr;
    }
    return Math.min(first, second);
}