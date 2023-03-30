//https://practice.geeksforgeeks.org/problems/1ccf56f107bcb24242469ea45c02f852165a2184/1

class Solution {
    public static int minimumInteger(int N, int[] A) {
        // code here
        long total = 0;
        for(int i = 0; i < N; i++)
            total += A[i];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++)
        {
            if(total <= (long) N * A[i])
                ans = Math.min(ans, A[i]);
        }
        return ans;
    }
}
