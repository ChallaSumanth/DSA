//Google 11 Amazon 6
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, dfs(i, manager, informTime));
        return ans;
    }
    private int dfs(int i, int[] manager, int[] informTime)
    {
        if(manager[i] != -1)
        {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
}