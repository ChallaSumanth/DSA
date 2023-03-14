//https://practice.geeksforgeeks.org/problems/7ae455e552dc4e07f76bbe2adc4d4207ce1ff16e/1
//makeMyTrip
class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		int len = arr.size();
		int [] array = new int[len + 2];
		array[0] = 1;
		array[len + 1] = 1;
		for(int i = 1; i <= len; i++)
		    array[i] = arr.get(i - 1);
		int [][] dp = new int[len + 2][len + 2];
		for(int [] row : dp) Arrays.fill(row, - 1);
		return solve(array, 0, len + 1, dp);
	}
	private int solve(int[] arr, int start, int end, int[][] dp)
	{
	    if(end - start == 1) return 0;
	    
	    if(dp[start][end] != -1) return dp[start][end];
	    
	    int ans = 0;
	    for(int i = start + 1; i < end; i++)
	    {
	        int cur = arr[start] * arr[i] * arr[end] + solve(arr, start, i, dp) + solve(arr, i ,end, dp);
	        
	        ans = Math.max(ans, cur);
	    }
	    return dp[start][end] = ans;
	}
}