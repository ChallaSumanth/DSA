//Facebook 140 Amazon 16 LinkedIn 14 Microsoft 12 Google 8 Bloomberg 5 Adobe 5 tiktok 3 Goldman Sachs 2
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums)
        {
            pq.offer(num);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
