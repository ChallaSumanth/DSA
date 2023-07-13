//Microsoft 10 Facebook 9 tiktok 7 Google 5 Apple 3 Uber 2 Bloomberg 2 Oracle 2
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        List<List<Integer>> adj = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            for(int nei : adj.get(i))
                indegree[nei]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
                qu.offer(i);
        }
        List<Integer> finished = new ArrayList<>();
        while(!qu.isEmpty())
        {
            int cur = qu.poll();
            finished.add(cur);
            for(int nei : adj.get(cur))
            {
                 indegree[nei]--;
                 if(indegree[nei] == 0)
                    qu.offer(nei);
            }
        }
        return finished.size() == numCourses;
    }
    private  List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        for(int [] prerequisite : prerequisites)
            adj.get(prerequisite[1]).add(prerequisite[0]);
        return adj;
    }
}