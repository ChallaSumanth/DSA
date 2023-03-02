//https://practice.geeksforgeeks.org/problems/9dacc32ad062be6e2ba8f6c41aad0b2b2376397d/1

//1.memorization tle
class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n = costs.length;
		int k = costs[0].length;
	
	    if(n > 1 && k == 1) return -1;
	    int [][] dp = new int[n][k+1];
	    for(int [] arr : dp)
	        Arrays.fill(arr,-1);
		return solve(costs, n - 1, k, dp);
	}
	private int solve(int[][] costs, int wall, int last, int [][] dp)
	{
	    if(wall == 0)
	    {
	        int min = Integer.MAX_VALUE;
	        for(int i = 0; i < costs[0].length; i++)
	        {
	            if(i != last)
	            {
	               min = Math.min(min, costs[wall][i]);
	            }
	        }
	        return dp[wall][last] = min;
	    }
	    if(dp[wall][last] != -1) return dp[wall][last];
	    int ans = Integer.MAX_VALUE;
	    for(int i = 0; i < costs[0].length; i++)
	    {
	        int min = Integer.MAX_VALUE;
	        if(i != last)
	            min = costs[wall][i] + solve(costs, wall - 1, i, dp);
	        ans = Math.min(ans, min);   
	    }
	    return dp[wall][last] = ans;
	}
}

//2.optimal tc : o(n * k) sc: o(n * k)

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n = costs.length;
		int k = costs[0].length;
	
	    if(n > 1 && k == 1) return -1;
	    int [][] dp = new int[n][k];
	    for(int i = 0; i < k; i++)
	        dp[0][i] = costs[0][i];
	    for(int i = 1; i < n; i++)
	    {
	        int first_min = Integer.MAX_VALUE;
	        int second_min = Integer.MAX_VALUE;
	        for(int j = 0; j < k; j++)
	        {
	            if(dp[i - 1][j] < first_min)
	            {
	                second_min = first_min;
	                first_min = dp[i - 1][j];
	            }
	            else if(dp[i - 1][j] < second_min)
	                second_min = dp[i - 1][j];
	        }
	        for(int j = 0; j < k; j++)
	        {
	            if(dp[i - 1][j] != first_min)
	                dp[i][j] = costs[i][j] + first_min;
	            else
	                dp[i][j] = costs[i][j] + second_min;
	        }
	    }
	    int ans = Integer.MAX_VALUE;
	    for(int i = 0; i < k; i++)
	        ans = Math.min(ans, dp[n - 1][i]);
	   return ans;
	}
}
