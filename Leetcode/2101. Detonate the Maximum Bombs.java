class Solution {
    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        Map<Integer, List<Integer>> neighbours = buildGraph(bombs);
        int maxCount = 0;
        for(int startbomb = 0; startbomb < len; startbomb++)
        {
            int count = countDetonations(startbomb, neighbours);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
    private  Map<Integer, List<Integer>> buildGraph(int[][] bombs)
    {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = bombs.length;
        for(int i = 0; i < len; i++)
        {
            List<Integer> neighbours = new ArrayList<>(); 
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for(int j = 0; j < len; j++)
            {
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                if(i != j)
                {
                    if((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 * r1)
                        neighbours.add(j);
                }
            }
            graph.put(i, neighbours);
        }
        return graph;
    }
    private int countDetonations(int startIndex, Map<Integer, List<Integer>> graph)
    {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(startIndex);
        Set<Integer> reachable = new HashSet<>();
        reachable.add(startIndex);
        while(!qu.isEmpty())
        {
            int size = qu.size();
            while(size-- > 0)
            {
                int bomb = qu.poll();
                for(int neighbour : graph.get(bomb))
                {
                    if(!reachable.contains(neighbour))
                    {
                        reachable.add(neighbour);
                        qu.offer(neighbour);
                    }
                }
            }
        }
        return reachable.size();
    }
}