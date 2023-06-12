//Yandex 6 Qualtrics 2
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return ans;
        int a = nums[0];
        for(int i = 0; i < len; i++)
        {
            if(i == len - 1 || nums[i] + 1 != nums[i + 1])
            {
                if(nums[i] != a)
                {
                    ans.add(a+"->"+nums[i]);
                }
                else
                {
                    ans.add(a+"");
                }
            if(i != len - 1)
                a = nums[i + 1];
            }
        }
        return ans;
    }
}