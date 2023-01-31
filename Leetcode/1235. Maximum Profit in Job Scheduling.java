class Jobs{
    int start;
    int end;
    int profit;
    Jobs(int start,int end,int profit)
    {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Jobs[] job = new Jobs[n];
        for(int i=0;i<n;i++)
            job[i] = new Jobs(startTime[i],endTime[i],profit[i]);
        Arrays.sort(job,(a,b)->(a.end - b.end));
        int [] dp = new int[n];
        dp[0] = job[0].profit;
        for(int i=1;i<n;i++)
        {
            dp[i] = Math.max(dp[i-1],job[i].profit);
            for(int j=i-1;j>=0;j--)
            {
                if(job[j].end <= job[i].start)
                {
                    dp[i] = Math.max(dp[i] , job[i].profit + dp[j]);
                    break;
                }
            }
        }
        return dp[n-1];
    }
}