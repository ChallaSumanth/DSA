//1.DFS
class Solution {
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited)
    {
        visited[node] = true;
        for(int neighbour : graph.get(node))
        {
            if(!visited[neighbour])
                dfs(neighbour, graph, visited);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        List<List<Integer>> graph = buildGraph(n, connections);
        boolean[] visited = new boolean[n];
        int individualNodes = 0;
        for(int i = 0; i < n ; i++)
        {
            if(!visited[i])
            {
                dfs(i, graph, visited);
                individualNodes++;
            }
        }
        return individualNodes - 1;
    }
    private List<List<Integer>> buildGraph(int n, int[][] connections)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n ; i++)
            graph.add(new ArrayList<>());
        for(int [] connection : connections)
        {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        return graph;
    }
}
//2.BFS
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        List<List<Integer>> graph = buildGraph(n, connections);
        boolean[] visited = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                ans++;
                visited[i] = true;
                qu.offer(i);
                while(!qu.isEmpty())
                {
                    int curNode = qu.poll();
                    for(int nei : graph.get(curNode))
                    {
                        if(!visited[nei])
                        {
                            visited[nei] = true;
                            qu.offer(nei);
                        }
                    }
                }
            }
        }
       return ans - 1;
    }
    private List<List<Integer>> buildGraph(int n, int[][] connections)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n ; i++)
            graph.add(new ArrayList<>());
        for(int [] connection : connections)
        {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
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
        int UParent = findUParent(parent.get(node));
        parent.set(node, UParent);
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
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if(len < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < len; i++)
            uf.UnionBySize(connections[i][0], connections[i][1]);
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(i == uf.findUParent(i))
                ans++;
        }
        return ans - 1;  
    }
}