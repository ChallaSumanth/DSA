class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int len = cookies.length;
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        solve(cookies, 0, len, k, new int[k], ans);
        return ans[0];
    }
    private void solve(int[] cookies, int index, int len, int k, int[] cookiesAfterSplit, int[] ans)
    {
        if(index == len)
        {
            int maxi = Integer.MIN_VALUE;
            for(int cookie : cookiesAfterSplit)
                maxi = Math.max(maxi, cookie);
            ans[0] = Math.min(ans[0], maxi);
            return;
        }
        for(int i = 0; i < k; i++)
        {
            cookiesAfterSplit[i] += cookies[index];
            solve(cookies, index + 1, len, k, cookiesAfterSplit, ans);
            cookiesAfterSplit[i] -= cookies[index];
        }
    }
}