//Google 6 Amazon 6 Facebook 2 Adobe 2
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if(mat == null || m == 0 || n == 0)
            return new int[0][0];
        int[][] ans = new int[n][m];
        Queue<int[]> qu = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 0)
                {
                    qu.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        int [] dx = new int[]{1, 0, -1, 0};
        int [] dy = new int[]{0, 1, 0, -1};
        while(!qu.isEmpty())
        {
            int[] cur = qu.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];
            ans[row][col] = dist;
            for(int i = 0; i < 4; i++)
            {
                int nx = row + dx[i];
                int ny = col + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                qu.offer(new int[]{nx, ny, dist + 1});
            }
        }
        return ans;
    }
}