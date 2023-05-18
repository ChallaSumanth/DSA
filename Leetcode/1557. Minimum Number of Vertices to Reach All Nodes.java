//Google 2 Amaazon 2
//1.By checking the indegree
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(List<Integer> edge : edges)
        {
            visited[edge.get(1)] = true;
        }
        for(int i = 0; i < n; i++)
            if(!visited[i]) ans.add(i);
        return ans;
    }
}
//2.Union Find
class DisJointSetUnion
{
    public DisJointSetUnion(List<Integer> parent, int n)
    {
        for(int i = 0; i < n; i++)
            parent.add(i);
    }
    public int findUParent(int node, List<Integer> parent)
    {
        if(parent.get(node) == node)
            return node;
        int ul_P = findUParent(parent.get(node), parent);
        parent.set(node, ul_P);
        return parent.get(node);
    }
    public void unionByParent(int u, int v, List<Integer> parent)
    {
        int ul_pu = findUParent(u, parent);
        int ul_pv = findUParent(v, parent);
        parent.set(ul_pv, ul_pu);
    }
}
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> parent = new ArrayList<>();
        DisJointSetUnion dsu = new DisJointSetUnion(parent , n);
        boolean[] visited = new boolean[n];
        for(List<Integer> edge : edges)
        {
            if(!visited[edge.get(1)])
            {
                dsu.unionByParent(edge.get(0), edge.get(1), parent);
                visited[edge.get(1)] = true;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(parent.get(i) == i) ans.add(i);
        }
        return ans;
    }
}