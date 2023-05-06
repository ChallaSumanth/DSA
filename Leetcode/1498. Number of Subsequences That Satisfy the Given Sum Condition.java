//1. using binary component
class Solution {
    private long power(long a, long n, long p)
    {
        long res = 1;
        while(n > 0) // O(log n)
        {
            if(n % 2 == 1)
            {
                res = (res * a) % p;
                n--;
            }
            else
            {
                a = (a * a) % p;
                n = n / 2;
            }
        }
        return res;
    }
    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int mod = 1000000007;
        for(int i = 0, j = len - 1; i <= j; i++)
        {
            while(i <= j && nums[i] + nums[j] > target)
                --j;
            if(j >= i)
            {
                int pw = (int)power(2, j - i, mod);
                res = (res + pw) % mod;
            }
        }
        return res;
    }
}
//2. by precomputing powers

class Solution {
    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int mod = 1000000007;
        int [] powers = new int[len + 1];
        powers[0] = 1;
        for(int i = 1; i <= len; i++)
            powers[i] = (powers[i - 1] << 1) % mod;
        for(int i = 0, j = len - 1; i <= j; i++)
        {
            while(i <= j && nums[i] + nums[j] > target)
                --j;
            if(j >= i)
            {
                int pw = powers[j - i];
                res = (res + pw) % mod;
            }
        }
        return res;
    }
}
//3.
class Solution {
    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int mod = 1000000007;
        int [] powers = new int[len + 1];
        powers[0] = 1;
        for(int i = 1; i <= len; i++)
            powers[i] = (powers[i - 1] << 1) % mod;
        int l = 0, r = len - 1;
        while(l <= r)
        {
            if(nums[l] + nums[r] > target)
                r--;
            else
                res = (res + powers[r - l++]) % mod;
        }
        return res;
    }
}