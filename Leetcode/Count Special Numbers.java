//https://practice.geeksforgeeks.org/problems/3d49e4cce2820a813da02d1587c2dd9c542ce769/1
//intuit
class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here
        int max = arr[0];
        for(int i = 1; i < N; i++) max = Math.max(max, arr[i]);
        int [] special = new int[max + 1];
        for(int i = 0; i < N; i++)
        {
            if(special[arr[i]] < 2)
                for(int j = arr[i]; j <= max; j += arr[i]) special[j]++;
        }
        int ans = 0;
        for(int ele : arr) if(special[ele] > 1) ans++;
        return ans;
    }
}