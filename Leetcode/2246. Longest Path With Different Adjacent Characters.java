class Solution {
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        List<List<Integer>> graph = buildGraph(parent,s,n);
        int [] dist = new int[n];
        int [] ans = new int[1];
        ans[0] = 1;
        solve(graph,0,s,dist,ans);
        return ans[0];
    }
    private void solve(List<List<Integer>> graph,int node,String s,int [] dist,int [] ans)
    {
        dist[node] = 1;
        for(int nextNode : graph.get(node))
        {
            solve(graph,nextNode,s,dist,ans);
            if(s.charAt(nextNode) == s.charAt(node))
                continue;
            ans[0] = Math.max(ans[0],dist[node] + dist[nextNode]);
            dist[node] = Math.max(dist[node],dist[nextNode] + 1);
        }
    }
    private List<List<Integer>> buildGraph(int[] parent,String s,int n)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int i=1;i<n;i++)
            graph.get(parent[i]).add(i);
        return graph;
    }
}