// GFG  //Amazon,OYO
//1.Recursion 
class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        return fun(n-1,arr);
    }
    private int fun(int ind,int[] arr)
    {
        if(ind == 0) return arr[ind];
        if(ind < 0) return 0;
        
        int pick = arr[ind] + fun(ind-2,arr);
        int notPick = fun(ind-1,arr);
        return Math.max(pick,notPick);
    }
}

//2.Memorization
class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return fun(n-1,arr,dp);
    }
    private int fun(int ind,int[] arr,int[] dp)
    {
        if(ind == 0) return arr[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = arr[ind] + fun(ind-2,arr,dp);
        int notPick = fun(ind-1,arr,dp);
        return dp[ind] = Math.max(pick,notPick);
    }
}

//3.Tabulation
class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            int pick = arr[i];
            if(i>1)
            pick += dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}

//4.Space Optimization
class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int prev2 = 0;
        int prev1 = arr[0];
        for(int i=1;i<n;i++)
        {
            int pick = arr[i];
            if(i>1)
            pick += prev2;
            int notpick = prev1;
            int cur = Math.max(pick,notpick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}