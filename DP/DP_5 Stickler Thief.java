//
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