class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long [] dp = new long[len];
        Arrays.fill(dp, -1l);
        return solve(0, questions, dp, len);
    }
    private long solve(int index, int[][] questions, long[] dp, int len)
    {
        if(index >= len) return 0;
        if(dp[index] != -1l) return dp[index];
        long pick = questions[index][0] + solve(index + questions[index][1] + 1, questions, dp, len);

        long notPick = solve(index + 1,questions, dp, len);

        return dp[index] = Math.max(pick, notPick); 
    }
}
//2.iterative dp
class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[200001];
        int len = questions.length;
        for(int i = len - 1; i >= 0; i--)
            dp[i] = Math.max(questions[i][0] + dp[i + questions[i][1] + 1], dp[i + 1]);
        return dp[0];
    }
}