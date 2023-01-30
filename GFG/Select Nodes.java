//Flipkart 
class Solution{
    public int countVertex(int N, int[][] edges){
        // code here
        List<List<Integer>> adj = buildGraph(N,edges);
        boolean visited [] = new boolean[N+1];
        int [] count = new int[1];
        dfs(adj,1,visited,count);
        return count[0];
    }
    private boolean dfs(List<List<Integer>> adj,int node,boolean visited[],int [] count)
    {
        if(visited[node]) return false;
        visited[node] = true;
        boolean lighted = false;
        for(int nbr : adj.get(node))
        {
            if(!visited[nbr])
            {
                if(!dfs(adj,nbr,visited,count)) // child is not lighted  so requires light
                    lighted = true;
            }
        }
        if(lighted)
            count[0]++;
        return lighted;
    }
    private List<List<Integer>> buildGraph(int N,int [][] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
             adj.get(edges[i][0] - 1).add(edges[i][1] - 1);
             adj.get(edges[i][1] - 1).add(edges[i][0] - 1);
        }
        
        return adj;
    }
}