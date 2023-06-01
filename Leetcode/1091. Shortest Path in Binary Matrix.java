//Facebook 76 Amazon 9 Microsoft 8 Google 5 Snapchat 3 Adobe 2
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> qu = new LinkedList<>();
        int[][] dis = new int[n][n];
        for(int[] row : dis)
            Arrays.fill(row, Integer.MAX_VALUE);
        qu.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[] dx = new int[]{1, 0, -1, 0, 1, -1, -1, 1};
        int[] dy = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
        int steps = Integer.MAX_VALUE;
        while(!qu.isEmpty())
        {
            int[] cur = qu.poll();
            int x = cur[0];
            int y = cur[1];
            int step = cur[2];
            if(x == n - 1 && y == n - 1)
                steps = Math.min(steps, step);
            for(int i = 0; i < 8; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && 1 + step < dis[nx][ny] && grid[nx][ny] == 0) 
                {
                    dis[nx][ny] = 1 + step;
                    visited[nx][ny] = true;
                    qu.offer(new int[]{nx, ny, 1 + step});
                    grid[nx][ny] = 1;
                }
            }
        }
        return steps == Integer.MAX_VALUE ? -1 : steps + 1;
    }
}