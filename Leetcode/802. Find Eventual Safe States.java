class Solution {
    private boolean dfs(int node, int[] visited, int[] dfsVisited, boolean[] checkIsSafe, int[][] graph)
    {
        visited[node] = 1;
        dfsVisited[node] = 1;
        for(int nei : graph[node])
        {
            if(visited[nei] == 0)
            {
                if(dfs(nei, visited, dfsVisited, checkIsSafe, graph))
                    return true;
            }
            else if(dfsVisited[nei] == 1)
                    return true;
        }
        checkIsSafe[node] = true;
        dfsVisited[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int len = graph.length;
        if(graph == null || len == 0) return ans;
        int[] visited = new int[len];
        int[] dfsVisited = new int[len];
        boolean[] checkIsSafe = new boolean[len];
        for(int i = 0; i < len; i++)
        {
            if(visited[i] == 0)
                dfs(i, visited, dfsVisited, checkIsSafe, graph);
        }
        for(int i = 0; i < len; i++)
        {
            if(checkIsSafe[i])
                ans.add(i);
        }
        return ans;
    }
}