//https://practice.geeksforgeeks.org/problems/7995e41d167d81f14f1d4194b29ef839f52d18ba/1

class Solution {
    public static int minimumTime(int N, int cur, int[] pos, int[] time) {
        // code here
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++)
        {
            ans = Math.min(ans,Math.abs(cur - pos[i]) * time[i]);
        }
        return ans;
    }
}