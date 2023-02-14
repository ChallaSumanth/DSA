class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int [][] dp = new int[N][3];
        // for(int [] a : dp)
        //     Arrays.fill(a,-1);
        // return dfs(colors,N-1,3,dp);
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];
        for(int house = 1; house < N; house++)
        {
            dp[house][0] = colors[house][0] + Math.min(dp[house - 1][1],dp[house - 1][2]);
            dp[house][1] = colors[house][1] + Math.min(dp[house - 1][0],dp[house - 1][2]);
            dp[house][2] = colors[house][2] + Math.min(dp[house - 1][0],dp[house - 1][1]);
        }
        return Math.min(Math.min(dp[N - 1][0],dp[N-1][1]),dp[N - 1][2]);
    }
    private int dfs(int [][] colors,int day,int last,int[][] dp)
    {
        if(dp[day][last] != -1)
            return dp[day][last];
        if(day == 0)
        {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++)
            {
                if(i !=  last)
                {
                    min = Math.min(colors[0][i],min);   
                }
            }
            return dp[day][last] = min;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++)
        {
            int val = 0;
            if(i != last)
            {
                val = colors[day][i] + dfs(colors,day - 1,i,dp);
                min = Math.min(min,val);
            }
        }
        return dp[day][last] = min;
    }
}