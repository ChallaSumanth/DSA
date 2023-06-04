class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int provinces = 0;
        for(int i = 0; i < len; i++)
        {
            if(!visited[i])
            {
                provinces++;
                dfs(i, isConnected, visited, len);
            }
        }
        return provinces;
    }
    private void dfs(int node, int[][] isConnected, boolean[] visited, int len)
    {
        visited[node] = true;
        for(int neighbour = 0; neighbour < len; neighbour++)
        {
            if(isConnected[node][neighbour] == 1 && !visited[neighbour])
                dfs(neighbour, isConnected, visited, len);
        }
    }
}