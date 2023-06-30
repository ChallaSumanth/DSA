class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans = 0;
        int lo = 1;
        int hi = cells.length;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(canReach(cells, row, col, mid))
            {
                ans = mid;
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ans;
    }
    private boolean canReach(int[][] cells, int row, int col, int day)
    {
        int[][] grid = new int[row][col];
        Queue<int[]> qu = new LinkedList<>();
        for(int i = 0; i < day; i++)
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        for(int i = 0; i < col; i++)
        {
            if(grid[0][i] == 0)
            {
                qu.offer(new int[]{0, i});
                grid[0][i] = 1;
            }
        }
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while(!qu.isEmpty())
        {
            int curRow = qu.peek()[0];
            int curCol = qu.peek()[1];
            qu.poll();
            if(curRow == row - 1)
                return true;
            for(int i = 0; i < 4; i++)
            {
                int nx = curRow + dx[i];
                int ny = curCol + dy[i];

                if(nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] == 1)
                    continue;
                grid[nx][ny] = 1;
                qu.offer(new int[]{nx, ny});
            }
        }
        return false;
    }
}