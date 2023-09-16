class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[]{0 , 0, 0});
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        dist[0][0] = 0;
        while(!minHeap.isEmpty())
        {
            int[] cur = minHeap.poll();
            int dis = cur[0];
            int x = cur[1];
            int y = cur[2];
            if(dis > dist[x][y])
                continue;
            if(x == row - 1 && y == col - 1)
                return dis;
            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= row || ny < 0 || ny >= col)
                    continue;
                int newDist = Math.max(dis, Math.abs(heights[nx][ny] - heights[x][y]));
                if(dist[nx][ny] > newDist)
                {
                    dist[nx][ny] = newDist;
                    minHeap.offer(new int[]{newDist, nx, ny});
                } 
            }
        }
        return 0;
    }
}