//tc: o(3n) sc:O(2n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] ans = new int[len];
        int [] prefixProduct = new int[len];
        int [] suffixProduct = new int[len];

        prefixProduct[0] = 1;
        for(int i = 1; i < len; i++)
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        suffixProduct[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--)
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        
        for(int i = 0; i < len; i++)
            ans[i] = prefixProduct[i] * suffixProduct[i];
        return ans;
    }
}
//2.optimal tc:O(2n) sc:O(1) // not considering ans array
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] ans = new int[len];
        ans[0] = 1;
        for(int i = 1; i < len; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        int right = 1;
        for(int i = len - 1; i >= 0; i--)
        {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
}