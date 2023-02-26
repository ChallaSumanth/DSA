//https://practice.geeksforgeeks.org/problems/1a4b617b70f0142a5c2b454e6fbe1b9a69ce7861/1

class Solution {
    private void dfs(int i,boolean [] visited ,int size,ArrayList<ArrayList<Integer>> adj, int[] nodeCount,boolean [] isSizeEqual)
    {
        visited[i] = true;
        nodeCount[0]++;
        if(size != adj.get(i).size())
           isSizeEqual[0] = false; 
        for(int x : adj.get(i))
        {
            if(!visited[x])
                 dfs(x,visited,size,adj,nodeCount,isSizeEqual);
        }
    }
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int ans = 0;
        boolean [] visited = new boolean[V+1];
        int[] nodeCount = new int[1];
        boolean [] isSizeEqual = new boolean[1];
        for(int i = 1; i <= V; i++)
        {
            if(!visited[i])
            {
                nodeCount[0] = 0;
                isSizeEqual[0] = true;
                dfs(i,visited,adj.get(i).size(),adj,nodeCount,isSizeEqual);
                if((isSizeEqual[0] == true) && (nodeCount[0] - 1 == adj.get(i).size())) ans++;
            }
        }
        return ans;
    }
}