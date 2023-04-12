class Solution {
    public static int dominantPairs(int n, int[] arr) {
        // code here
        Arrays.sort(arr, 0 , n / 2);
        Arrays.sort(arr, n / 2, n);
        
        int count = 0;
        int i = 0;
        int j = n / 2;
        while(i < n / 2 && j < n)
        {
            if(arr[i] >= 5 * arr[j])
            {
                count += n / 2 - i;
                j++;
            }
            else
                i++;
        }
        return count;
    }
}