//Microsoft
//1.Bfs
class Pair
{
    int node;
    int dist;
    Pair(int node, int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> graph = buildGraph(n, roads);
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1);
        boolean visited[] = new boolean[n + 1];
        int ans = Integer.MAX_VALUE;
        while(!qu.isEmpty())
        {
            int node = qu.poll();
            for(Pair p: graph.get(node))
            {
                int vertex = p.node;
                int dist = p.dist;
                ans = Math.min(ans, p.dist);
                if(!visited[vertex])
                {
                    visited[vertex] = true;
                    qu.offer(p.node);
                }
            }
        }
        return ans;
    }
    private List<List<Pair>> buildGraph(int n, int[][] roads)
    {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for(int [] road : roads)
        {
            graph.get(road[0]).add(new Pair(road[1],road[2]));
            graph.get(road[1]).add(new Pair(road[0],road[2]));
        }
        return graph;
    }
}
//2.dfs
class Pair
{
    int node;
    int dist;
    Pair(int node, int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> graph = buildGraph(n, roads);
        boolean visited[] = new boolean[n + 1];
        int ans[] = new int[1];
        ans[0] = Integer.MAX_VALUE;
        return dfs(1, ans, graph, visited);
    }
    private int dfs(int node, int [] ans, List<List<Pair>> graph, boolean[] visited)
    {
        visited[node] = true;
        for(Pair p : graph.get(node))
        {
            node = p.node;
            int dist = p.dist;
            ans[0] = Math.min(ans[0], dist);
            if(!visited[node])
            {
                visited[node] = true;
                ans[0] = Math.min(ans[0], dfs(node, ans, graph, visited));
            }
        }
        return ans[0];
    }
    private List<List<Pair>> buildGraph(int n, int[][] roads)
    {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for(int [] road : roads)
        {
            graph.get(road[0]).add(new Pair(road[1],road[2]));
            graph.get(road[1]).add(new Pair(road[0],road[2]));
        }
        return graph;
    }
}
//3.union find
class UnionFind
{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    UnionFind(int n)
    {
        for(int i = 0; i <= n; i++)
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
    public void UnionBySize(int u , int v)
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
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n+1);
        for(int[] road : roads)
        {
            uf.UnionBySize(road[0], road[1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int [] road : roads)
        {
            int from_a = uf.findUParent(road[0]);
            int from_b = uf.findUParent(road[1]);
            if(from_a == 1 && from_b == 1)
                ans = Math.min(ans, road[2]);
        }
        return ans;
    }
}