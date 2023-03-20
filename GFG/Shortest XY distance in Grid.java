//https://practice.geeksforgeeks.org/problems/7366ce450d84b55391fc787a681c4d60de359e72/1
//google

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        //code here
        Queue<int[]> qu = new LinkedList<>();
        boolean [][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(grid.get(i).get(j) == 'X')
                {
                    qu.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        int [] dx = new int[]{1,0,0,-1};
        int [] dy = new int[]{0,-1,1,0};
        while(!qu.isEmpty())
        {
            int size = qu.size();
            while(size-- > 0)
            {
                int x = qu.peek()[0];
                int y = qu.peek()[1];
                qu.poll();
                if(grid.get(x).get(y) == 'Y') return ans;
                for(int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M &&  !visited[nx][ny])
                    {
                        qu.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            ans++;
        }
        return ans;
    }
};