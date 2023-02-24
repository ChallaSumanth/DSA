//https://practice.geeksforgeeks.org/problems/e7d81a082cda6bd1e959d943197aa3bc21b88bdb/1
//uber
//Expected Time Complexity: O((m+n)log(n))
//Expected Auxiliary Space: O(n+m)
class Pair
{
    int node;
    int dist;
    Pair(int node,int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    private static int[] dijstra(int source,int n, ArrayList<ArrayList<Pair>> adj)
    {
        int [] dist = new int[n + 1];
        Arrays.fill(dist,(int) 1e9);
        dist[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.dist - b.dist));
        pq.offer(new Pair(source,0));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dist;
            for(int i = 0; i < adj.get(node).size(); i++)
            {
                int adjnode = adj.get(node).get(i).node;
                int edjweight = adj.get(node).get(i).dist;
                if(dis + edjweight < dist[adjnode])
                {
                    dist[adjnode] = dis + edjweight;
                    pq.offer(new Pair(adjnode,dist[adjnode]));
                }
            }
        }
        return dist;
    }
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge : edges)
        {
            adj.get(edge.get(0)).add(new Pair(edge.get(1),edge.get(2)));
            adj.get(edge.get(1)).add(new Pair(edge.get(0),edge.get(2)));
        }
        
        int[] from_a = dijstra(a,n,adj);
        int[] from_b = dijstra(b,n,adj);
        int ans = from_a[b];
        if(ans == (int) 1e9) return -1;
        
        for(ArrayList<Integer> edge : edges)
        {
            if(from_a[edge.get(0)] != 1e9 && from_b[edge.get(1)] != 1e9)
                ans = Math.min(ans,from_a[edge.get(0)] + edge.get(3) + from_b[edge.get(1)]);
            if(from_a[edge.get(1)] != 1e9 && from_b[edge.get(0)] != 1e9)
                ans = Math.min(ans,from_b[edge.get(0)] + edge.get(3) + from_a[edge.get(1)]);
        }
        return ans;
    }
};