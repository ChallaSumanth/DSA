//https://practice.geeksforgeeks.org/problems/a3493283697b7b69573a840f371a55ccd9332bb0/1

class Solution {
    public static long bestNode(int N, int[] A, int[] P) {
        // code here
        int [] sign = new int[N+1];
        for(int i = 1; i < N; i++)
            sign[P[i]]++;
        long ans = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++)
        {
           if(sign[i] == 0)
           {
                int j = i;
                long temp = 0;
                while(j != -1)
                {
                    temp += A[j - 1];
                    j = P[j - 1];
                    ans = Math.max(ans, temp);
                    temp *= -1;
                }
           }
        }
        return ans;
    }
}