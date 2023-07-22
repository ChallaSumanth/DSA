class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return false;
        Arrays.sort(nums);
        int maxElementPresent = nums[len - 1];
        //if(len != maxElementPresent + 1) return false;
        if(len >= 2 && maxElementPresent != nums[len - 2])
            return false;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len - 1; i++)
        {
            if(map.containsKey(nums[i])) return false;
            else
            {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                sum += nums[i];
            }
        }
        int b = len - 1;
        //System.out.println( b * (b + 1) / 2 +" :: " + maxElementPresent);
         return sum + maxElementPresent ==   b * (b + 1) / 2 + maxElementPresent;
    }
}