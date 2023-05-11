//1.recursion - tle
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length - 1;
        int m = nums2.length - 1;
        return solve(nums1, nums2, n, m);
    }
    private int solve(int[] nums1, int[] nums2, int i, int j)
    {
        if(i < 0 || j < 0) return 0;

        int count = 0;

        if(nums1[i] == nums2[j])
            count = 1 + solve(nums1, nums2, i - 1, j - 1);
        else
            count += Math.max(solve(nums1, nums2, i - 1, j), solve(nums1, nums2, i, j - 1));
        return count;
    }
}
//2.memorization - tle
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length - 1;
        int m = nums2.length - 1;
        int [][] dp = new int[n + 1][m + 1];
        return solve(nums1, nums2, n, m, dp);
    }
    private int solve(int[] nums1, int[] nums2, int i, int j, int[][] dp)
    {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != 0) return dp[i][j];
        int count = 0;

        if(nums1[i] == nums2[j])
            count = 1 + solve(nums1, nums2, i - 1, j - 1, dp);
        else
            count += Math.max(solve(nums1, nums2, i - 1, j, dp), solve(nums1, nums2, i, j - 1, dp));
        return dp[i][j] = count;
    }
}
//3.Tabulation
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
       return dp[n][m];
    }
}
//Space optimization
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] dp = new int[m + 1];
        for(int i = 1; i <= n; i++)
        {
            int[] curState = new int[m + 1];
            for(int j = 1; j <= m; j++)
            {
                if(nums1[i - 1] == nums2[j - 1])
                    curState[j] = 1 + dp[j - 1];
                else
                    curState[j] = Math.max(dp[j], curState[j - 1]);
            }
            dp = curState;
        }
       return dp[m];
    }
}
//optimal
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] dp = new int[m + 1];
        for(int i = 1; i <= n; i++)
        {
            int prev = 0;
            for(int j = 1; j <= m; j++)
            {
                int cur = dp[j];
                if(nums1[i - 1] == nums2[j - 1])
                    dp[j] = 1 + prev;
                else
                    dp[j] = Math.max(dp[j - 1], cur);
                prev = cur;
            }
        }
       return dp[m];
    }
}