//Google
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len];
        return mincostTickets(days, costs, 0, 0, dp, len);
    }
    private int mincostTickets(int[] days, int[] costs, int index, int lastPassGoodUntil, int[] dp, int len)
    {
        if(index >= len) return 0;

        if(days[index] <= lastPassGoodUntil)
            return mincostTickets(days, costs, index + 1, lastPassGoodUntil, dp, len);
        if(dp[index] != 0) return dp[index];

        int minCost = Math.min(
            costs[0] + mincostTickets(days, costs, index + 1, days[index], dp, len),
            Math.min(costs[1] + mincostTickets(days, costs, index + 1, days[index] + 6, dp, len),
                    costs[2] + mincostTickets(days, costs, index + 1, days[index] + 29, dp, len))
        );

        dp[index] = minCost;
        return minCost;
    }
}