//1.recursion
//v.imp
class Solution {
    public int minDistance(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }
    private int solve(String word1, String word2, int i, int j)
    {
        if(i == word1.length())
            return word2.length() - j;
        if(j == word2.length())
            return word1.length() - i;
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j))
            return solve(word1, word2, i + 1, j + 1);
        else
        {
            //insert
            int insertAns = 1 + solve(word1, word2, i, j + 1);
            //delete
            int deleteAns = 1 + solve(word1, word2, i + 1, j);
            //replace
            int replaceAns = 1 + solve(word1, word2, i + 1, j + 1);

            ans = Math.min(insertAns,Math.min(deleteAns,replaceAns));
        }
        return ans;
    }
}
//2.memorization
class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()][word2.length()];
        for(int [] arr : dp)
            Arrays.fill(arr,-1);
        return solve(word1, word2, 0, 0, dp);
    }
    private int solve(String word1, String word2, int i, int j,  int [][] dp)
    {
        if(i == word1.length())
            return word2.length() - j;
        if(j == word2.length())
            return word1.length() - i;
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j))
            return solve(word1, word2, i + 1, j + 1, dp);
        else
        {
            //insert
            int insertAns = 1 + solve(word1, word2, i, j + 1, dp);
            //delete
            int deleteAns = 1 + solve(word1, word2, i + 1, j, dp);
            //replace
            int replaceAns = 1 + solve(word1, word2, i + 1, j + 1, dp);

            ans = Math.min(insertAns,Math.min(deleteAns,replaceAns));
        }
        return dp[i][j] = ans;
    }
}

//3.Tabulation
class Solution {
    public int minDistance(String word1, String word2) {
       int[][] dp = new int[word1.length() + 1][word2.length() + 1];
       for(int j = 0; j < word2.length(); j++)
            dp[word1.length()][j] = word2.length() - j;
       for(int i = 0; i < word1.length(); i++)
            dp[i][word2.length()] = word1.length() - i;
       for(int i = word1.length() - 1; i >= 0; i--)
       {
           for(int j = word2.length() - 1; j >= 0; j--)
           {
               int ans = 0;
               if(word1.charAt(i) == word2.charAt(j))
                    ans = dp[i + 1][j + 1];
                else
                {
                    //insert
                    int insertAns = 1 + dp[i][j + 1];
                    //delete
                    int deleteAns = 1 + dp[i + 1][j];
                    //replace
                    int replaceAns = 1 + dp[i + 1][j + 1];

                    ans = Math.min(insertAns,Math.min(deleteAns,replaceAns));
                }
                dp[i][j] = ans;
            }
       }
       return dp[0][0];
    }
}