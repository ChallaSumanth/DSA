class Solution {
    public int longestCycle(int[] edges) {
        int len = edges.length;
        int[][] cycleTracker = new int[len][2];

        //distance, sourceNode
        Arrays.fill(cycleTracker, new int[]{-1,-1});
        int ans = -1;
        for(int i = 0; i < len; i++)
        {
            int dist = 0;
            int j = i;
            while(j != -1)
            {
                int distanceFromSourceNode = cycleTracker[j][0];
                int curSourceNode = cycleTracker[j][1];

                if(distanceFromSourceNode == -1)
                {
                    cycleTracker[j] = new int[]{dist++, i};
                }
                else
                {
                    if(curSourceNode == i)
                        ans = Math.max(ans, dist - distanceFromSourceNode);
                    break;
                }
                 j = edges[j];
            }
        }
        return ans;
    }
}