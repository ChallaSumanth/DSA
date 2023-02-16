//https://practice.geeksforgeeks.org/problems/e2d156755ca4e0a9b9abf5680191d4b06e52b1a8/1

class Solution {
    private static boolean loopfound = false;
    public static int goodStones(int n, int[] arr) {
        // code here
        int ans = 0;
        boolean [] visited = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                loopfound = false;
                dfs(i,n,arr,visited);
            }
        }
        for(int i = 0; i < n; i++)
            if(!visited[i])
                ans++;
        return ans;
    }
    private static void dfs(int node,int n,int [] arr,boolean[] visited)
    {
        visited[node] = true;
        int child = node + arr[node];
        if(child < n && child > -1)
        {
            if(visited[child])
                loopfound = true;
            else
                dfs(child,n,arr,visited);
        }
        if(!loopfound)
            visited[node] = false;
    }
}
        
