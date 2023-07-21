//Amazon 2 Google 2
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] freq = new int[len];
        int[] length = new int[len];
        Arrays.fill(freq, 1);
        Arrays.fill(length, 1);
        int maxLen = 1;
        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    if(length[j] + 1 > length[i])
                    {
                        length[i] = length[j] + 1;
                        freq[i] = freq[j];
                    }
                    else if(length[j] + 1 == length[i])
                    freq[i] += freq[j];
                }
            }
            maxLen = Math.max(maxLen, length[i]);
        }
        int ans = 0;
        for(int i = 0; i < len; i++)
            if(length[i] == maxLen)
                ans += freq[i];
        return ans;
    }
}