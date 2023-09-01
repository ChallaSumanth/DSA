//Amazon 3 Google 2 Bloomberg 2 JPMorgan 2
class Solution {
    public int[] countBits(int n) {
        int [] ans = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}
//2.
class Solution {
    public int[] countBits(int n) {
        int [] ans = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            ans[i] = solve(i);
        }
        return ans;
    }
    private int solve(int n)
    {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n % 2 == 0) return solve(n / 2);
        else
            return 1 + solve(n / 2);
    }
}