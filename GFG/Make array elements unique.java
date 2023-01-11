//Dunzo
class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        long ans = 0;
        Arrays.sort(arr);
        for(int i=1;i<N;i++)
        {
            if(arr[i] <= arr[i-1])
            {
                ans += arr[i-1] - arr[i] + 1;
                arr[i] = arr[i-1] + 1;
            }
        }
        return ans;
    }
}