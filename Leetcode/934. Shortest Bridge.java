//Microsoft
class Pair
{
    int row;
    int col;
    Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    private void dfs(int[][] grid, int i, int j, int m, int n, int[] dx, int[] dy, Queue<Pair> qu,boolean[][] visited)
    {
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == 0)
            return;
        visited[i][j] = true;
        qu.offer(new Pair(i, j));
        for(int x = 0; x < 4; x++)
        {
            int nx = i + dx[x];
            int ny = j + dy[x];
            dfs(grid, nx, ny, m, n, dx, dy, qu,visited);
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> qu = new LinkedList<>();
        boolean flag = false;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid, i, j, m, n, dx, dy, qu, visited);
                    flag = true;
                    break;
                }
            }
             if(flag) break;
        }
        int steps = 0;
        while(!qu.isEmpty())
        {
            int size = qu.size();
            while(size-- > 0)
            {
                Pair p = qu.poll();
                int i = p.row;
                int j = p.col;
                for(int x = 0; x < 4; x++)
                {
                    int nx = i + dx[x];
                    int ny = j + dy[x];
                    if(nx >= 0  && nx < n && ny >= 0 && ny < m && !visited[nx][ny])
                    {
                        if(grid[nx][ny] == 1)
                            return steps;
                        qu.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}