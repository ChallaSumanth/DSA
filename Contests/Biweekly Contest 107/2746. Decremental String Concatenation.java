class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        int len = words.length;
        int [][][] dp = new int[len][27][27];
        for(int[][] mat : dp)
            for(int[] row : mat)
                Arrays.fill(row, -1);
        return words[0].length() + minimizeConcatenatedLen(1, words, words[0].charAt(0) - 'a', words[0].charAt(words[0].length() - 1) - 'a', dp, len);
    }
    private int minimizeConcatenatedLen(int index, String[] words, int first, int last, int[][][] dp, int len)
    {
        if(index == len)
            return 0;
        if(dp[index][first][last] != -1)
            return dp[index][first][last];
        int curWordLen = words[index].length();
        int min = Integer.MAX_VALUE;
        if(first == words[index].charAt(curWordLen - 1) - 'a')
        {
            min = Math.min(min, minimizeConcatenatedLen(index + 1, words, words[index].charAt(0) - 'a', last, dp, len) + curWordLen - 1);
        }
        else
        {
            min = Math.min(min, minimizeConcatenatedLen(index + 1, words, words[index].charAt(0) - 'a', last, dp, len) + curWordLen);
        }
        if(last == words[index].charAt(0) - 'a')
        {
            min = Math.min(min, minimizeConcatenatedLen(index + 1, words, first, words[index].charAt(curWordLen - 1) - 'a' , dp, len) + curWordLen - 1);
        }
        else
        {
            min = Math.min(min, minimizeConcatenatedLen(index + 1, words, first, words[index].charAt(curWordLen - 1) - 'a', dp, len) + curWordLen);
        }
        return dp[index][first][last] = min;
    }
}