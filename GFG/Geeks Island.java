//https://practice.geeksforgeeks.org/problems/234ca3b438298fb04befd5abe7fbd98c006d4884/1
class Solution{
	int water_flow(int [][] mat, int N, int M) {
		//Write your code here
		boolean [][] indian = new boolean[N][M];
		boolean [][] arabian = new boolean[N][M];
		
		for(int i = 0; i < M; i++)
		{
		    dfs(0,i,indian,mat,N,M);
		    dfs(N - 1,i,arabian,mat,N,M);
		}
		for(int i = 0; i < N; i++)
		{
		    dfs(i,0,indian,mat,N,M);
		    dfs(i,M - 1,arabian,mat,N,M);
		}
		int ans = 0;
		for(int i = 0; i < N; i++)
		{
		    for(int j = 0; j < M; j++)
		    {
		        if(indian[i][j] && arabian[i][j])
		            ans++;
		    }
		}
		return ans;
	}
	private void dfs(int i, int j, boolean [][] array,int[][] mat, int row, int col)
	{
	    if(array[i][j]) return;
	    array[i][j] = true;
	    if(i + 1 < row && mat[i + 1][j] >= mat[i][j]) dfs(i + 1, j ,array, mat, row, col);
	    if(i - 1 >= 0 && mat[i - 1][j] >= mat[i][j]) dfs(i - 1, j ,array, mat, row, col);
	    if(j + 1 < col && mat[i][j + 1] >= mat[i][j]) dfs(i, j + 1 ,array, mat, row, col);
	    if(j - 1 >= 0 && mat[i][j - 1] >= mat[i][j]) dfs(i , j - 1 ,array, mat, row, col);
	}
}