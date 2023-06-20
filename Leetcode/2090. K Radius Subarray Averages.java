//Facebook 3
//1.Brute
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len];
        if(k == 0)
            return nums;
        Arrays.fill(ans, -1);
        if(len < k)
            return ans;
        long[] preSum = new long[len];
        long[] suffSum = new long[len];
        preSum[0] = nums[0];
        suffSum[len - 1] = nums[len - 1];
        for(int i = 1; i < len; i++)
            preSum[i] = preSum[i - 1] + nums[i];
        for(int i = len - 2; i >= 0; i--)
            suffSum[i] = suffSum[i + 1] + nums[i];
        for(int i = k; i < len - k; i++)
        {
            long prefix = 0;
            long suffix = 0;
            long ksum = 0;
            boolean check = true;
            if(i - k == 0)
                prefix = preSum[i];
            else if(i - k - 1 >= 0)
                prefix = preSum[i] - preSum[i - k - 1];
            else 
                check = false;
            if(i + k == len - 1)
                suffix = suffSum[i];
            else if(i + k + 1 < len)
                suffix = suffSum[i] - suffSum[i + k + 1];
            else
                check = false;
            //System.out.println(check +"pref "+prefix +"suff "+suffix) ;
            if(check)
            {
                ksum = prefix + suffix - nums[i];
                ans[i] = (int) (ksum/(k + k + 1));
            }
        }
        return ans;
    }
}
//2.Better
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len];
        if(k == 0)
            return nums;
        Arrays.fill(ans, -1);
        if(len < k)
            return ans;
        long[] preSum = new long[len + 1];      
        for(int i = 0; i < len; i++)
            preSum[i + 1] = preSum[i] + nums[i];
        for(int i = k; i + k < len; i++)
        {
            ans[i] = (int)((preSum[i + k + 1] - preSum[i - k]) / (2 * k + 1));
        }
        return ans;
    }
}
//3.optimal
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len];
        if(k == 0)
            return nums;
        Arrays.fill(ans, -1);
        if(len < k)
            return ans;
        long sum = 0;
        int n = 2 * k + 1;
        for(int i = 0; i < len; i++)
        {
            sum += nums[i];
            if(i - n >= 0) sum -= nums[i - n];
            if(i >= n - 1) ans[i - k] = (int) (sum / n);
        }
        return ans;
    }
}