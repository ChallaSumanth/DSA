//https://practice.geeksforgeeks.org/problems/d4aeef538e6dd3280dda5f8ed7964727fdc7075f/1

class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long[] ans = new long[n];
        for(int i = 1; i < n; i++)
            ans[i] = ans[i - 1] + a[i] - a[i / 2];
        return ans;
    }
}