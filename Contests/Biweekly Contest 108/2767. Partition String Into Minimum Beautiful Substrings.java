class Solution {
    public int minimumBeautifulSubstrings(String s) {
        Set<String> good = new HashSet<>();
        int len = s.length();
        for(int i = 1; i < 1 << len; i *= 5)
            good.add(Integer.toBinaryString(i));
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(dp[j] < Integer.MAX_VALUE && good.contains(s.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[len] == Integer.MAX_VALUE ? -1 : dp[len];
    }
}