//Microsoft Interview
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = buildAdjList(edges,n);
        return shortestTimeToCollect(0,0,adj,hasApple);
    }
    private int shortestTimeToCollect(int idx,int parent,List<List<Integer>> adj,List<Boolean> hasApple)
    {
        int pathLength = 0;
        for(int nbr : adj.get(idx))
        {
            if(nbr == parent)
                continue;
            pathLength += shortestTimeToCollect(nbr,idx,adj,hasApple);
        }
        if(idx != 0 && (hasApple.get(idx) || pathLength > 0))
            pathLength += 2;
        return pathLength;
    }
    private List<List<Integer>> buildAdjList(int[][] edges,int n)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int edge[] : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}