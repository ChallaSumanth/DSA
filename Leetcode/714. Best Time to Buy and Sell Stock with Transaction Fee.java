//Amazon 3 Facebook 2
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int effectiveBuyPrice = prices[0];
        int profit = 0;
        for(int i = 1; i < len; i++)
        {
            profit = Math.max(profit, prices[i] - effectiveBuyPrice - fee);
            effectiveBuyPrice = Math.min(effectiveBuyPrice, prices[i] - profit);
        }
        return profit;
    }
}