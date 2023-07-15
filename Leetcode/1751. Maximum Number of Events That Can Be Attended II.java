//1.Recursion
class Solution {
    public int maxValue(int[][] events, int k) {
        int len = events.length;
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        return maxValue(events, len, 0, k);
    }
    private int maxValue(int[][] events, int len, int pos, int k)
    {
        if(pos == len || k == 0) return 0;
        int i;
        for(i = pos + 1; i < len; i++)
            if(events[i][0] > events[pos][1])
                break;
        int take = events[pos][2] + maxValue(events, len, i, k - 1);
        int notTake = maxValue(events, len, pos + 1, k);
        return Math.max(take, notTake);
    }
}
//2.Memorization
class Solution {
    public int maxValue(int[][] events, int k) {
        int len = events.length;
        int[][] dp = new int[len][k + 1];
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        return maxValue(events, len, 0, k, dp);
    }
    private int maxValue(int[][] events, int len, int pos, int k, int[][] dp)
    {
        if(pos == len || k == 0) return 0;
        if(dp[pos][k] != 0) return dp[pos][k];
        int i;
        for(i = pos + 1; i < len; i++)
            if(events[i][0] > events[pos][1])
                break;
        int take = events[pos][2] + maxValue(events, len, i, k - 1, dp);
        int notTake = maxValue(events, len, pos + 1, k, dp);
        return dp[pos][k] = Math.max(take, notTake);
    }
}
//Binary search  TC : O(n * k * log n) || SC : O(n * k)
class Solution {
    public int maxValue(int[][] events, int k) {
        int len = events.length;
        int[][] dp = new int[len][k + 1];
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        return maxValue(events, len, 0, k, dp);
    }
    private int maxValue(int[][] events, int len, int pos, int k, int[][] dp)
    {
        if(pos == len || k == 0) return 0;
        if(dp[pos][k] != 0) return dp[pos][k];
        
        int nextTake = findNextTake(events, events[pos][1], pos + 1, len);
        int take = events[pos][2] + maxValue(events, len, nextTake, k - 1, dp);
        int notTake = maxValue(events, len, pos + 1, k, dp);
        return dp[pos][k] = Math.max(take, notTake);
    }
    private int findNextTake(int[][] events, int last, int lo, int len)
    {
        int hi = len - 1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(events[mid][0] <= last)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}