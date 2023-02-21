//https://practice.geeksforgeeks.org/problems/2145720aebf8ea0b07f76b17217b3353a0fbea7f/1
//oracle
//1.Bfs tc:o(n*m) sc:o(n*m);
class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int [][] mat = new int[N][M];
		mat[x-1][y-1] = 1;
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[]{x-1,y-1});
		int level = 0;
		int[] dx = new int[]{1,0,0,-1};
		int[] dy = new int[]{0,1,-1,0};
		while(!qu.isEmpty())
		{
		    int size = qu.size();
		    while(size-- >0)
		    {
		        int row = qu.peek()[0];
		        int col = qu.peek()[1];
		        qu.poll();
		        for(int i = 0; i < 4; i++)
		        {
		            int nx = dx[i] + row;
		            int ny = dy[i] + col;
		            
		            if(nx < N && nx >= 0 && ny < M && ny >= 0 && mat[nx][ny] == 0)
		            {
		                qu.offer(new int[]{nx,ny});
		                mat[nx][ny] = 1;
		            }
		        }
		    }
		    level++;
		}
		return level - 1;
	}
}
//2.optimal
class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int ans = 0;
		for(int i = 1; i <= N; i++)
		{
		    for(int j = 1; j <= M; j++)
		    {
		        ans = Math.max(ans,Math.abs(x - i) + Math.abs(y - j));
		    }
		}
		return ans;
	}
}