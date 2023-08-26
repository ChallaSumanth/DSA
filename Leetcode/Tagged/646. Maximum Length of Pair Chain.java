//Amazon 2 Flipkart 2
//1.recursion - tle
class Solution {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        return solve(pairs, 0, len, Integer.MIN_VALUE);
    }
    private int solve(int[][] pairs, int index, int len, int prev)
    {
        if(index >= len)
            return 0;
        int include = 0;
        if(pairs[index][0] > prev)
            include =  1 + solve(pairs, index + 1, len, pairs[index][1]);
        int exclude = solve(pairs, index + 1, len, prev);
        return Math.max(include, exclude);
    }
}
//2.memorization
class Solution {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int[][] dp = new int[len][2002];
        return solve(pairs, 0, len, -1001, dp);
    }
    private int solve(int[][] pairs, int index, int len, int prev, int[][] dp)
    {
        if(index >= len)
            return 0;
        if(dp[index][prev + 1001] != 0)
            return dp[index][prev + 1001];
        int include = 0;
        if(pairs[index][0] > prev)
            include =  1 + solve(pairs, index + 1, len, pairs[index][1], dp);
        int exclude = solve(pairs, index + 1, len, prev, dp);
        return dp[index][prev + 1001] = Math.max(include, exclude);
    }
}
//3.
class Solution {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int ans = 1;
        for(int i = 0; i < len; i++)
        {
            int count = 1;
            int prev = pairs[i][1];
            for(int j = i + 1; j < len; j++)
            {
                if(pairs[j][0] > prev)
                {
                    prev = pairs[j][1];
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
//4.optimal
class Solution {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int count = 0, i = 0;
        while(i < len)
        {
            count++;
            int prev = pairs[i][1];
            while(i < len && pairs[i][0] <= prev)
                i++;
        }
        return count;
    }
}
