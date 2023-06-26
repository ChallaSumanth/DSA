//LinkedIn 29 Amazon 17 Microsoft 3 Bloomberg 3 Infosys 3 Google 2 Adobe 2
//1.Brute
class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 0;
        int len = nums.length;
        if(len == 1)
            return nums[0];
        for(int i = 0; i < len; i++)
        {
            int curProduct = nums[i];
            maxProduct = Math.max(maxProduct, curProduct);
            for(int j = i + 1; j < len; j++)
            {
                curProduct *= nums[j];
                maxProduct = Math.max(maxProduct, curProduct);
            }
        }
        return maxProduct;
    }
}
//2.Optimal kadane's variation
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int prefixProduct = 0;
        int suffixProduct = 0;
        int maxProduct = nums[0];
        for(int i = 0; i < len; i++)
        {
            prefixProduct = (prefixProduct == 0 ? 1 : prefixProduct) * nums[i];
            suffixProduct = (suffixProduct == 0 ? 1 : suffixProduct) * nums[len - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }
        return maxProduct;
    }
}
