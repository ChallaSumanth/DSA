//Yandex 3
//1.sliding window
class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int max = 0;
        int lastIndex = 0;
        int k = 1;
        for(int i = 0; i < len; i++)
        {
            if(nums[i] == 0)
                k--;
            while(k < 0)
            {
                if(nums[lastIndex] == 0)
                    k++;
                lastIndex++;
            }
            max = Math.max(max, i - lastIndex);
        }
        return max;
    }
}
//2.count cur and prev consecutive 1's for each zero
class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int maxOnes = 0;
        int prevOnesCount = 0;
        int curOnescount = 0;
        for(int i = 0; i < len; i++)
        {
            if(nums[i] == 1)
                curOnescount++;
            else
            {
                maxOnes = Math.max(maxOnes, curOnescount + prevOnesCount);
                prevOnesCount = curOnescount;
                curOnescount = 0;
            }
        }
         maxOnes = Math.max(maxOnes, curOnescount + prevOnesCount);
        return maxOnes == len  ? maxOnes - 1 : maxOnes;
    }
}