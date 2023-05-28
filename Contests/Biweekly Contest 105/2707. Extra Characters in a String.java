class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        for(String word : dictionary)
            set.add(word);
        int [] dp = new int[len + 1];
        for(int i = 1; i <= len; i++)
        {
            dp[i] = dp[i - 1] + 1;
            for(int j = i; j >= 1; j--)
            {
                String substr = s.substring(j - 1, i);
                if(set.contains(substr))
                {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
            }
        }
        return dp[len];
    }
}