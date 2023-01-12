class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int [] temp = new int[n-1];
        int [] temp1 = new int[n-1];
        int j = 0,k = 0;
        for(int i=0;i<n;i++)
        {
            if(i!=0) temp[j++] = nums[i];
            if(i!=n-1) temp1[k++] = nums[i];
        }
        return Math.max(maxAmount(temp,n-1),maxAmount(temp1,n-1));
    }
    private int maxAmount(int [] arr,int n)
    {
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++)
        {
            int fs = arr[i];
            if(i>1)
            fs += prev2;
            int ss = prev;
            int cur = Math.max(fs,ss);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}