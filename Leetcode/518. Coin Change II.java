//1.recursion
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        return change(amount, 0, coins, len);
    }
    private int change(int balance, int curIndex, int [] coins, int len)
    {
        if(balance == 0)
            return 1;
        if(balance < 0 || curIndex == len) 
            return 0;
        int take = change(balance - coins[curIndex], curIndex, coins, len);
        int notTake = change(balance, curIndex + 1, coins, len);
        return take + notTake;
    }
}
//2.memorization
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[amount + 1][len + 1];
        return change(amount, 0, coins, len, dp);
    }
    private int change(int balance, int curIndex, int [] coins, int len, int[][] dp)
    {
        if(balance == 0)
            return 1;
        if(balance < 0 || curIndex == len) 
            return 0;
        if(dp[balance][curIndex] != 0)
            return dp[balance][curIndex];
        int take = change(balance - coins[curIndex], curIndex, coins, len, dp);
        int notTake = change(balance, curIndex + 1, coins, len, dp);
        return dp[balance][curIndex] = take + notTake;
    }
}
//3.Tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= len; i++)
        {
            dp[i][0] = 1;
            for(int j = 1; j <= amount; j++)
            {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[len][amount];
    }
}