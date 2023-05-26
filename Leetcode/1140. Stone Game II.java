class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] suffixSum = new int[len];
        int[][] memo = new int[len][len];
        suffixSum[len - 1] = piles[len - 1];
        for(int i = len - 2; i >= 0; i--)
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        return helper(piles, memo, suffixSum, 0, 1, len);
    }
    private int helper(int[] piles, int[][] memo, int[] suffixSum, int i, int m, int len)
    {
        if(i == len) return 0;
        if(i + 2 * m >= len) return suffixSum[i];
        if(memo[i][m] != 0) return memo[i][m];

        int result = 0;
        for(int x = 1; x <= 2 * m; x++)
            result = Math.max(result, suffixSum[i] - helper(piles, memo, suffixSum, i + x, Math.max(x, m), len));
        return memo[i][m] = result;
    }
}