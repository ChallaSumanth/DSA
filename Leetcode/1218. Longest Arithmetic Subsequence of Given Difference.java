//1.Recursion - tle
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int maxLen = 1;
        int len = arr.length;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(arr[j] - arr[i] == difference)
                    maxLen = Math.max(maxLen, 2 + longestSubseq(arr, i, difference));
            }
        }
        return maxLen;
    }
    private int longestSubseq(int[] arr, int index, int difference)
    {
        if(index < 0) return 0;

        int ans = 0;

        for(int j = index - 1; j >= 0; j--)
        {
            if(arr[index] - arr[j] == difference)
            {
                ans = Math.max(ans, 1 + longestSubseq(arr, j, difference));
            }
        }
        return ans;
    }
}
//2.Memorization - tle
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int maxLen = 1;
        int len = arr.length;
        int[] dp = new int[len];
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(arr[j] - arr[i] == difference)
                    maxLen = Math.max(maxLen, 2 + longestSubseq(arr, i, difference, dp));
            }
        }
        return maxLen;
    }
    private int longestSubseq(int[] arr, int index, int difference, int[] dp)
    {
        if(index < 0) return 0;

        int ans = 0;
        if(dp[index] != 0) return dp[index];
        for(int j = index - 1; j >= 0; j--)
        {
            if(arr[index] - arr[j] == difference)
            {
                ans = Math.max(ans, 1 + longestSubseq(arr, j, difference, dp));
            }
        }
        return dp[index] = ans;
    }
}
//3.Tabulation -tle
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int maxLen = 1;
        int len = arr.length;
        int[] dp = new int[len];
        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] - arr[j] == difference)
                {
                    int count = 1;
                    if(dp[j] != 0)
                        count = dp[j];
                    dp[i] = 1 + count;
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}

//optimal Accepted
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 1;
        for(int i = 0; i < len; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            longest = Math.max(longest, map.get(arr[i]));
        }
        return longest;
    }
}