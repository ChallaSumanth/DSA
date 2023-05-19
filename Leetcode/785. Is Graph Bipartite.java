class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        for(int i = 0; i < len; i++)
        {
            if(colors[i] == 0 && !dfs(i, graph, colors, 1))
                return false;
        }
        return true;
    }
    private boolean dfs(int index, int[][] graph, int[] colors, int color)
    {
        colors[index] = color;
        for(int j = 0; j < graph[index].length; j++)
        {
            int k = graph[index][j];
            if(colors[k] == -color) continue;
            if(colors[k] == color || !dfs(k, graph, colors, -color))
                return false;
        }
        return true;
    }
}