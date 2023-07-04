//Amazon 5
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int sum = 0, mask = 0;
        for(int i = 0; i < 32; i++)
        {
            mask = (1 << i);
            sum = 0;
            for(int num : nums)
            {
                if((num & mask) != 0)  
                    sum++;
            }
            if(sum % 3 != 0) ans |= mask;
        }
        return ans;
    }
}