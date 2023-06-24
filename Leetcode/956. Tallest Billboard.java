//1.Recursion
class Solution {
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        return tallestHeight(0, 0, 0, rods, len);
    }
    private int tallestHeight(int i, int s1, int s2, int[] rods, int len)
    {
        if(i == len)
        {
            if(s1 == s2) return s1;
            return 0;
        }
        int notPick = tallestHeight(i + 1, s1, s2, rods, len);
        int addtoB1 = tallestHeight(i + 1, s1 + rods[i], s2, rods, len);
        int addtoB2 = tallestHeight(i + 1, s1, s2 + rods[i], rods, len);

        return Math.max(notPick, Math.max(addtoB1, addtoB2));
    }
}
//2.Memorization + Hashing
class Solution {
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        int[][] dp = new int[21][2 * 5000 + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int ans = tallestHeight(0, 0, rods, len, dp);
        return ans < 0 ? 0 : ans;
    }
    private int tallestHeight(int i, int diff,int[] rods, int len, int[][] dp)
    {
        if(i == len)
        {
            if(diff == 0) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][diff + 5000] != -1) return dp[i][diff + 5000];
        int notPick = tallestHeight(i + 1, diff, rods, len, dp);
        int addtoB1 = rods[i] + tallestHeight(i + 1, diff + rods[i], rods, len, dp);
        int addtoB2 = tallestHeight(i + 1, diff - rods[i], rods, len, dp);

        return dp[i][diff +5000] = Math.max(notPick, Math.max(addtoB1, addtoB2));
    }
}