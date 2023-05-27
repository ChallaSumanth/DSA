//Recursion
class Solution {
    private int solve(int[] stones, int len, int index, int[] dp)
    {
        if(index >= len) return 0;
    
        if(dp[index] != Integer.MIN_VALUE) return dp[index];
       int takeone = stones[index] - solve(stones, len, index + 1, dp);
        int taketwo = Integer.MIN_VALUE;
        if(index + 1 < len)
            taketwo = stones[index] + stones[index + 1] - solve(stones, len, index + 2, dp);
        int takethree = Integer.MIN_VALUE;
        if(index + 2 < len)
            takethree = stones[index] + stones[index + 1] + stones[index + 2] - solve(stones, len, index + 3, dp);
        return dp[index] = Math.max(takeone, Math.max(taketwo, takethree));
    }
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int [] dp = new int[len];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int value = solve(stoneValue, len, 0, dp);
        if(value > 0) return "Alice";
        if(value < 0) return "Bob";
        return "Tie";
    }
}
//tabulation
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int [] dp = new int[len + 1];
        for(int i = len - 1; i >= 0; i--)
        {
            int takeone = stoneValue[i] - dp[i + 1];

            int taketwo = Integer.MIN_VALUE;
            if(i + 1 < len)
                taketwo = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            int takethree = Integer.MIN_VALUE;
            if(i + 2 < len)
                takethree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            dp[i] = Math.max(takeone, Math.max(taketwo, takethree));
        }
        if(dp[0] > 0) return "Alice";
        if(dp[0] < 0) return "Bob";
        return "Tie";
    }
}
//space optimization
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int [] dp = new int[len + 1];
        int one = 0,two = 0, three = 0;
        for(int i = len - 1; i >= 0; i--)
        {
            int takeone = stoneValue[i] - one;

            int taketwo = Integer.MIN_VALUE;
            if(i + 1 < len)
                taketwo = stoneValue[i] + stoneValue[i + 1] - two;
            int takethree = Integer.MIN_VALUE;
            if(i + 2 < len)
                takethree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - three;
            int diff = Math.max(takeone, Math.max(taketwo, takethree));

            three = two;
            two = one;
            one = diff;
        }
        if(one > 0) return "Alice";
        if(one < 0) return "Bob";
        return "Tie";
    }
}