class Solution {
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph, int[] nodeCount, int[] edgeCount)
    {
        visited[node] = true;
        nodeCount[0]++;
        edgeCount[0] += graph.get(node).size();
        for(int nextNode : graph.get(node))
        {
            if(!visited[nextNode])
                dfs(nextNode, visited, graph, nodeCount, edgeCount);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            int[] nodeCount = new int[1];
            int[] edgeCount = new int[1];
            if(!visited[i])
            {
                dfs(i,visited,graph,nodeCount,edgeCount);
                if(nodeCount[0] * (nodeCount[0] - 1) == edgeCount[0]) ans++;
            }
        }
        return ans;
    }
    private List<List<Integer>> buildGraph(int n, int[][] edges)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}