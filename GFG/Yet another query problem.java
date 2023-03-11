//https://practice.geeksforgeeks.org/problems/ad6699d4aaf84c74b119fac3b65e9ceb3fc8ef14/1

class Solution {
    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int [][] prefix = new int[N][N+1];
        for(int i = 0; i < N; i++)
        {
            int count = 0;
            for(int j = i; j < N; j++)
            {
                if(A[i] == A[j]) count++;
            }
            prefix[i][count]++;
        }
        
        for(int i = 1; i < N; i++)
        {
            for(int j = 0; j <= N; j++)
            {
                prefix[i][j] += prefix[i - 1][j];
            }
        }
        
        for(int i = 0; i < num; i++)
        {
            int L = Q[i][0];
            int R = Q[i][1];
            int K = Q[i][2];
            
            if(L == 0) ans.add(prefix[R][K]);
            
            else ans.add(prefix[R][K] - prefix[L - 1][K]);
            
        }
        return ans;
    }
}

//2.optimal
class Solution {
    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] temp = new int[N];
        for(int i = 0; i < N; i++)
        {
            int count = 1;
            for(int j = i + 1; j < N; j++)
                if(A[i] == A[j]) count++;
            temp[i] = count;
        }
        
        for(int i = 0; i < num; i++)
        {
            int start = Q[i][0];
            int end = Q[i][1];
            int k = Q[i][2];
            int count = 0;
            for(int j = start; j <= end; j++)
                if(temp[j] == k) count++;
            ans.add(count);
        }
        return ans;
    }
}
        

        
