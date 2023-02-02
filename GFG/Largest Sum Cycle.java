// Juspay
class Solution{
    public long helper(int node,int [] Edge)
    {
        long sum = node;
        long [] vis = new long[Edge.length];
        vis[node] = 1;
        int temp = Edge[node];
        while(vis[temp] != 1)
        {
            sum += temp;
            vis[temp] = 1;
            temp = Edge[temp];
        }
        return sum;
    }
    public void checkCycle(int node,int[] Edge,int[] vis,int[] dfsVis,int[] Cycle)
    {
        vis[node] = 1;
        dfsVis[node] = 1;
        int next_node = Edge[node];
        if(next_node != -1)
        {
            if(vis[next_node] == 0)
                checkCycle(next_node,Edge,vis,dfsVis,Cycle);
            else if(dfsVis[next_node] == 1)
                    Cycle[0] = next_node;
        }
        dfsVis[node] = 0;
    }
    public long largesSumCycle(int N, int Edge[]){
        int [] vis = new int[N];
        int [] dfsVis = new int[N];
        long ans = -1;
        for(int i = 0; i < N; i++)
        {
            int [] Cycle = new int[1];
            Cycle[0] = -1;
            long curSum = 0;
            if(vis[i] == 0)
            {
                checkCycle(i,Edge,vis,dfsVis,Cycle);
                if(Cycle[0] != -1)
                {
                    long sum =  helper(Cycle[0],Edge);
                    ans = Math.max(ans,sum);
                }
            }
        }
        return ans;
    }
}