//https://practice.geeksforgeeks.org/problems/aa0000a5f710ce8d41366b714341eef644ec7b82/1
//ola

//1.recursion tc : 3^n
class Solution{
    private static int mod = (int)1e9 + 7;
	public static int countPaths(int N){
		//code here
		return solve(N,'O');
	}
	private static int solve(int n,char loc)
	{
	    if(n == 0 && loc == 'O') return 1;
	    if(n == 0 && loc != 'O') return 0;
	    
	    int ans = 0;
	    if(loc == 'O')
	    {
	        ans = (ans + solve(n - 1, 'A')) % mod;
	        ans = (ans + solve(n - 1, 'B')) % mod;
	        ans = (ans + solve(n - 1, 'C')) % mod;
	    }
	    if(loc == 'A')
	    {
	        ans = (ans + solve(n - 1, 'O')) % mod;
	        ans = (ans + solve(n - 1, 'B')) % mod;
	        ans = (ans + solve(n - 1, 'C')) % mod;
	    }
	    if(loc == 'B')
	    {
	        ans = (ans + solve(n - 1, 'A')) % mod;
	        ans = (ans + solve(n - 1, 'O')) % mod;
	        ans = (ans + solve(n - 1, 'C')) % mod;
	    }
	    if(loc == 'C')
	    {
	        ans = (ans + solve(n - 1, 'O')) % mod;
	        ans = (ans + solve(n - 1, 'B')) % mod;
	        ans = (ans + solve(n - 1, 'A')) % mod;
	    }
	    return ans;
	}
}

//2.memorization
class Solution{
    private static int mod = (int)1e9 + 7;
	public static int countPaths(int N){
		//code here
	
		int [][] dp = new int[4][N+1];
		for(int [] a:dp)
		Arrays.fill(a,-1);
			return solve(N,'O',dp);
	}
	private static int solve(int n,char loc,int[][] dp)
	{
	    if(n == 0 && loc == 'O') return 1;
	    if(n == 0 && loc != 'O') return 0;
	    int ans = 0;
	    if(loc == 'O')
	    {
	        if(dp[0][n] != -1) return dp[0][n];
	        ans = (ans + solve(n - 1, 'A',dp)) % mod;
	        ans = (ans + solve(n - 1, 'B',dp)) % mod;
	        ans = (ans + solve(n - 1, 'C',dp)) % mod;
	        
	        return dp[0][n] = ans;
	    }
	    if(loc == 'A')
	    {
	        if(dp[1][n] != -1) return dp[1][n];
	        
	        ans = (ans + solve(n - 1, 'O',dp)) % mod;
	        ans = (ans + solve(n - 1, 'B',dp)) % mod;
	        ans = (ans + solve(n - 1, 'C',dp)) % mod;
	        
	        return dp[1][n] = ans;
	    }
	    if(loc == 'B')
	    {
	        if(dp[2][n] != -1) return dp[2][n];
	        
	        ans = (ans + solve(n - 1, 'A',dp)) % mod;
	        ans = (ans + solve(n - 1, 'O',dp)) % mod;
	        ans = (ans + solve(n - 1, 'C',dp)) % mod;
	        
	        return dp[2][n] = ans;
	    }
	    if(loc == 'C')
	    {
	        if(dp[3][n] != -1) return dp[3][n];
	        
	        ans = (ans + solve(n - 1, 'O',dp)) % mod;
	        ans = (ans + solve(n - 1, 'B',dp)) % mod;
	        ans = (ans + solve(n - 1, 'A',dp)) % mod;
	        
	        return dp[3][n] = ans;
	    }
	    return ans;
	}
}

//3.Tabulation
class Solution{
	public static int countPaths(int N){
		//code here
		int mod = (int)1e9 + 7;
		int[][] dp = new int[4][N + 1];
		
		dp[0][0] = 1;
		for(int i = 1; i <= N; i++)
		{
		    for(int j = 0; j <= 3; j++)
		    {
		        dp[j][i] = (dp[j][i] + dp[(j + 1) % 4][i - 1]) % mod;
		        dp[j][i] = (dp[j][i] + dp[(j + 2) % 4][i - 1]) % mod;
		        dp[j][i] = (dp[j][i] + dp[(j + 3) % 4][i - 1]) % mod;
		    }
		}
		return dp[0][N];
	}
}

