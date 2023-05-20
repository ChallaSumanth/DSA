//Uber 14 Amazon 10 Google 8 Facebook 8 Snapchat 5 tiktok 4 Adobe 3 Bloomberg 2 BlackRock 2
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        int len = queries.size();
        double[] ans = new double[len];
        int i = 0;
        for(List<String> query : queries)
        {
            Set<String> visited = new HashSet<>();
            if(query.get(0).equals(query.get(1)))
            {
                if(graph.containsKey(query.get(0)))
                {
                    ans[i] = 1.0;
                    i++;
                }
                else
                {
                    ans[i] = -1;
                    i++;
                }
                continue;
            }
            double res = dfs(query.get(0), query.get(1), graph, visited);
            ans[i] = res;
            i++; 
        }
        return ans;
    }
    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited)
    {
        if(!graph.containsKey(start))
            return -1.0;
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        visited.add(start);
        Map<String, Double> StartMap = graph.get(start);
        for(Map.Entry<String, Double> entry : StartMap.entrySet())
        {
            if(!visited.contains(entry.getKey()))
            {
                double curVal = dfs(entry.getKey(), end, graph, visited);
                if(curVal != -1)
                    return curVal * entry.getValue();
            }
        }
        return -1;
    }
    private  Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values)
    {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for(List<String> equation : equations)
        {
            String start = equation.get(0);
            String end = equation.get(1);
            double val = values[i];
            i++;
            graph.putIfAbsent(start, new HashMap<>());

            graph.get(start).put(end, val);

            graph.putIfAbsent(end, new HashMap<>());

            graph.get(end).put(start, 1 / val);
        }
        return graph;
    }
}