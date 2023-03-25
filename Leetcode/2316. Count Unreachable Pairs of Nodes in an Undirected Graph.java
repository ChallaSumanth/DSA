//1.DFS
class Solution {
    private int dfs(int node, boolean[] visited, List<List<Integer>> graph)
    {
        visited[node] = true;
        int ans = 1;
        for(int nextNode : graph.get(node))
        {
            if(!visited[nextNode])
            ans += dfs(nextNode, visited, graph);
        }
        return ans;
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        long ans = 0;
        int[] count = new int[1];
        int size = n;
        for(int i = 0; i < size; i++)
        {
            if(!visited[i])
            {
                long cur = dfs(i, visited, graph);
                n -= cur;
                ans += n * cur;
            }
        }
        return ans;
    }
    private List<List<Integer>> buildGraph(int n, int[][] edges)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
//2.BFS
class Solution {
    private int bfs(int node, boolean[] visited, List<List<Integer>> graph)
    {
        visited[node] = true;
        int ans = 1;
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(node);
        while(!qu.isEmpty())
        {
            int curNode = qu.poll();
            for(int nextNode : graph.get(curNode))
            {
                if(!visited[nextNode])
                {
                    visited[nextNode] = true;
                    ans++;
                    qu.offer(nextNode);
                }
            }
        }
        return ans;
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        long ans = 0;
        int[] count = new int[1];
        int size = n;
        for(int i = 0; i < size; i++)
        {
            if(!visited[i])
            {
                long cur = bfs(i, visited, graph);
                n -= cur;
                ans += n * cur;
            }
        }
        return ans;
    }
    private List<List<Integer>> buildGraph(int n, int[][] edges)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
//3.UnionFind
class UnionFind
{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    UnionFind(int n)
    {
        for(int i = 0; i < n; i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUParent(int node)
    {
        if(parent.get(node) == node)
            return node;
        int ul_p = findUParent(parent.get(node));
        parent.set(node, ul_p);
        return parent.get(node);
    }
    public void UnionBySize(int u, int v)
    {
        int U_P = findUParent(u);
        int V_P = findUParent(v);
        if(U_P == V_P) return;
        if(U_P < V_P)
            parent.set(V_P, U_P);
        else
            parent.set(U_P, V_P);
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        UnionFind uf = new UnionFind(n);
        for(int edge[] : edges)
            uf.UnionBySize(edge[0], edge[1]);
        long[] ParentForChildren = new long[n];
        for(int i = 0; i < n; i++)
            ParentForChildren[uf.findUParent(i)]++;
        for(int i = 0; i < ParentForChildren.length; i++)
        {
            ans += (ParentForChildren[i] * (n - ParentForChildren[i]));
            n -= ParentForChildren[i];
        }
        return ans;
    }
}