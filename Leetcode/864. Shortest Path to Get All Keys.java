class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int max_len = -1, x = -1, y = -1;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                char ch = grid[i].charAt(j);
                if(ch == '@')
                {
                    x = i;
                    y = j;
                }
                if(ch >= 'a' && ch <= 'f')
                    max_len = Math.max(ch - 'a' + 1, max_len);
            }
        }
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{0, x, y});
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int steps = 0;
        while(!qu.isEmpty())
        {
            int size = qu.size();
            while(size-- > 0)
            {
                int[] curState = qu.poll();
                if(curState[0] == (1 << max_len) - 1)
                    return steps;
                for(int i = 0; i < 4; i++)
                {
                    int nx = curState[1] + dx[i];
                    int ny = curState[2] + dy[i];
                    int keys = curState[0];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    char ch = grid[nx].charAt(ny);
                    if(ch == '#')
                        continue;
                    if(ch >= 'a' && ch <= 'f')
                        keys |= 1 << (ch - 'a');
                    if(ch >= 'A' && ch <= 'F' && ((keys >> (ch - 'A')) & 1) == 0)
                        continue;
                    if(!visited.contains(keys + " " + nx + " " + ny))
                    {
                        visited.add(keys + " " + nx + " " + ny);
                        qu.offer(new int[]{keys, nx, ny});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}