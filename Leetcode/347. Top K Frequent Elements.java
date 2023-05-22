//Facebook 97 Amazon 29 Microsoft 12 Google 8 Oracle 7 Uber 6 Apple 5 Bloomberg 4 Adobe 3 Cisco 3
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.offer(entry);
            if(pq.size() > k)
                pq.poll();
        }
        int i = 0;
        while(!pq.isEmpty())
            ans[i++] = pq.poll().getKey();
        return ans;
    }
}