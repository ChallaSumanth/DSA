//https://practice.geeksforgeeks.org/problems/899540d741547e2d75d1c5c03a4161ab53affd13/1
class Solution{
	long maximizeMinHeight(int n, int k, int w,int [] a)
    {
        //Write your code here
        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for(int val : a)
            lo = Math.min(lo,val);
        hi = lo + k;
        long ans = 0;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(isPossible(n,k,w,a,mid)) {
               ans = mid;
               lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return ans;
    }
    private boolean isPossible(int n, int k, int w, int [] a,int height)
    {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = a[i];
        for(int i = 0; i < n; i++)
        {
            if(arr[i] < height)
            {
                int temp = height - arr[i];
                if(temp > k) return false;
                k -= temp;
                arr[i] = height;
                for(int j = i + 1; j < n && j < i + w; j++)
                    arr[j] += temp;
            }
        }
        return true;
    }
}
