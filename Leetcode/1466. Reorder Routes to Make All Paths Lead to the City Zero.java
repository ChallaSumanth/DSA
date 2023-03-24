class Solution {
    private int dfs(List<List<Integer>> graph, int from, boolean[] visited)
    {
        int change = 0;
        visited[from] = true;
        for(int nextNode : graph.get(from))
        {
            if(!visited[Math.abs(nextNode)])
                change += dfs(graph, Math.abs(nextNode), visited) + (nextNode > 0 ? 1 : 0);
        }
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = buildGraph(n, connections);
        return dfs(graph, 0, new boolean[n]);
    }
    private List<List<Integer>> buildGraph(int n, int[][] connections)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int [] connection : connections)
        {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(-connection[0]);
        }
        return graph;
    }
}