class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++)
            map.put(nums[i], 0);
        len = moveFrom.length;
        for(int i = 0; i < len; i++)
        {
            if(map.containsKey(moveFrom[i]))
            {
                map.remove(moveFrom[i]);
                map.put(moveTo[i], 0);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            ans.add(entry.getKey());
        return ans;
    }
}