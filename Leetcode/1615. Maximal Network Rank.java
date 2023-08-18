class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] count = new int[n];
        int max = 0;
        for(int[] road : roads)
        {
            count[road[0]]++;
            count[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                max = Math.max(max, count[i] + count[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return max;
    }
   
}