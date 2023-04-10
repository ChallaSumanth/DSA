class Solution {
    int binarysearch(int arr[], int n, int k) {
        // code here
        int lo = 0;
        int hi = n - 1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}