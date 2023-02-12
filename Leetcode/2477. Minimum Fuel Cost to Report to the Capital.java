class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = buildGraph(roads);
        long [] fuel = new long[1];
        dfs(graph,0,-1,fuel,seats);
        return fuel[0];

    }
    private int dfs(List<List<Integer>> graph,int curCity,int prevCity,long[] fuel,int seats)
    {
        int people = 1;
        for(int nextCity : graph.get(curCity))
        {
            if(nextCity == prevCity)
                continue;
            people += dfs(graph,nextCity,curCity,fuel,seats);
        }
        if(curCity != 0)
            fuel[0] += (long)(Math.ceil((double)people/seats));
        return people;
    }
    private List<List<Integer>> buildGraph(int [][] roads)
    {
        List<List<Integer>> graph = new ArrayList<>();
        int len = roads.length;
        for(int i = 0; i <= len; i++)
            graph.add(new ArrayList<>());
        for(int [] road : roads)
        {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        return graph;
    }
}