class Pair
{
    int destination;
    int price;
    Pair(int destination,int price)
    {
        this.destination = destination;
        this.price = price;
    }
}
class Tuple
{
    int stops;
    int source;
    int cost;
    Tuple(int stops,int source,int cost)
    {
        this.stops = stops;
        this.source = source;
        this.cost = cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int len = flights.length;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<len;i++)
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        Queue<Tuple> qu = new LinkedList<>();
        int [] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        qu.offer(new Tuple(0,src,0));
        while(!qu.isEmpty())
        {
            int stops = qu.peek().stops;
            int source = qu.peek().source;
            int cost = qu.peek().cost;
            qu.poll();
            if(stops > k) continue;
            for(int i = 0 ;i < adj.get(source).size(); i++)
            {
                int edjnode = adj.get(source).get(i).destination;
                int edjWeight = adj.get(source).get(i).price;
                if(cost + edjWeight < dist[edjnode] && stops <= k)
                {
                    dist[edjnode] = cost + edjWeight;
                    qu.offer(new Tuple(stops + 1,edjnode,cost + edjWeight));
                }
            }
        }
        return dist[dst] == (int)1e9 ? -1 : dist[dst]; 
    }
}
