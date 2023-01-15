/*Given an integer array nums and an integer k, return the number of good subarrays of nums.

A subarray arr is good if it there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j] */

class Solution {
    public long countGood(int[] nums, int k) {
        long val = 0;
        int first = 0;
        long ans = 0;
        int n =  nums.length;
        Map<Integer,Long> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(nums[i]))
                val += map.get(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0L)+1);
            while(val >= k)
            {
                ans += n - i;
                long removeFirst = map.get(nums[first]);
                val -= removeFirst - 1;
                if(removeFirst == 1)
                    map.remove(nums[first]);
                else
                    map.put(nums[first],removeFirst - 1);
                first++;
            }
        }
        return ans;
    }
}