class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> qu = new LinkedList<>();
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    qu.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        int [] dx = new int[]{1,0,-1,0};
        int [] dy = new int[]{0,1,0,-1};
        int max = -1;
        while(!qu.isEmpty())
        {
            int [] cur = qu.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            max = Math.max(max,dist);
            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx <= grid.length-1 && ny >= 0 && ny <= grid[0].length-1 && !visited[nx][ny])
                {
                    visited[nx][ny] = true;
                    grid[ny][ny] = 1 + dist;
                    qu.offer(new int[]{nx,ny,1+dist});
                }
            }
        }
        return max == 0 ? -1 : max;
    }
}