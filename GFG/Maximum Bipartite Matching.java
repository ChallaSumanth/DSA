
// [[1,1,0,0,0]
// [0,1,0,0,1]
// [1,0,0,0,0]]
// 0 -> 1
// 1 -> 4
// 2 -> 0
class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int m = G.length;
        int n = G[0].length;
        int [] job = new int[n];
        Arrays.fill(job,-1);
        int ans = 0;
        for(int i = 0; i < m; i++)
        {
            boolean [] visited = new boolean[n];
            if(canAccept(i,job,visited,G,n))
                ans++;
        }
        return ans;
    }
    private boolean canAccept(int person,int[] job,boolean[] visited,int[][] G,int n)
    {
        for(int i = 0; i < n; i++)
        {
            if(G[person][i] == 1 && !visited[i])
            {
                visited[i] = true;
                if(job[i] == -1)
                {
                    job[i] = person;
                    return true;
                }
                else if(canAccept(job[i],job,visited,G,n))
                {
                    job[i] = person;
                    return true;
                }
            }
        }
        return false;
    }
}