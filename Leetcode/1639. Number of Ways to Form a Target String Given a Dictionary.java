class Solution {
    public int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();
        int [] dp = new int[m + 1];
        int [][] freq = new int[n][26];
        int mod = (int)1e9 + 7;
        dp[0] = 1;
        for(String word : words)
        {
            for(int i = 0; i < n; i++)
                freq[i][word.charAt(i) - 'a']++;
        }
    
        for(int i = 0; i < n; i++)
        {
            for(int j = m - 1; j >= 0; j--)
            {
                dp[j + 1] += (int)((long) dp[j] * freq[i][target.charAt(j) - 'a'] % mod);
                dp[j + 1] %= mod;
            }
        }
        return dp[m]; 
    }
}