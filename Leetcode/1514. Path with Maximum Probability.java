//Google 5
class Pair
{
    int node;
    double cost;
    Pair(int node, double cost)
    {
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int len = edges.length;
        List<List<Pair>> graph = buildGraph(edges, len, n, succProb);
        double [] probability = new double[n];
        probability[start] = 1.0;
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        while(!qu.isEmpty())
        {
            int curStart = qu.poll();
            for(Pair pair: graph.get(curStart))
            {
                int neighbour = pair.node;
                double probabilty = pair.cost;
                double newProbabilty = probability[curStart] * probabilty;
                if(newProbabilty > probability[neighbour])
                {
                    probability[neighbour] = newProbabilty;
                    qu.offer(neighbour);
                }
            }
        }
        return probability[end];
    }
    private List<List<Pair>> buildGraph(int[][] edges, int len, int n, double[] succProb)
    {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int i = 0; i < len; i++)
        {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        return graph;
    }
}