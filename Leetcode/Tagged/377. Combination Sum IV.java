//Amazon 4 Google 3 Facebook 2 Microsoft 2
class Solution {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum(nums, target);
    }
    private int combinationSum(int[] nums, int target)
    {
        if(target == 0)
            return 1;
        if(target < 0)
            return 0;
        int count = 0;
        for(int num : nums)
            count += combinationSum(nums, target - num);
        return count;
        
    }
}
//2.
class Solution {
    public int combinationSum4(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
        return combinationSum(nums, target, map);
    }
    private int combinationSum(int[] nums, int target, Map<Integer, Integer> map)
    {
        if(target == 0)
            return 1;
        else if(target < 0)
            return 0;
        else if(map.containsKey(target))
            return map.get(target);
        else
        {
            int count = 0;
            for(int num : nums)
                count += combinationSum(nums, target - num, map);
            map.put(target, count);
            return count;
        }
    }
}