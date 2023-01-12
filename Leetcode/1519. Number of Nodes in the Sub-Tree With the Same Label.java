class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = buildGraph(edges,n);
        int [] ans = new int[n];
        dfs(-1,0,graph,labels,ans);
        return ans;
    }
    private int[] dfs(int parent,int child,List<List<Integer>> graph,String labels,int [] ans)
    {
        int count[] = new int[26];
        for(int node : graph.get(child))
        {
            if(node == parent) continue;
            int [] res = dfs(child,node,graph,labels,ans);
            for(int i=0;i<res.length;i++)
                count[i] += res[i];
        }
        char ch = labels.charAt(child);
        ans[child] = ++count[ch-'a']; // increase for self node
        return count;
    }
    private List<List<Integer>> buildGraph(int[][] edges,int n)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int edge[]:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}