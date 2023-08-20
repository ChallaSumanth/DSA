//Zoho Amazon MakeMyTrip
class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int first = binarySearch(arr, n, x);
        int last = binarySearch1(arr, n, x);
        //System.out.println(last +"::" +first);
        if(last == -1)
            return 0;
        return last - first + 1;
    }
    private int binarySearch(int [] nums, int n, int x)
    {
        int lo = 0;
        int hi = n - 1;
        int ans = -1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(nums[mid] == x)
            {
                ans = mid;
                hi = mid - 1;
            }
           else if(nums[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return ans;
    }
     private int binarySearch1(int [] nums, int n, int x)
    {
        int lo = 0;
        int hi = n - 1;
        int ans = -1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(nums[mid] == x)
            {
                ans = mid;
                lo = mid + 1;
            }
            else if(nums[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return ans;
    }
}