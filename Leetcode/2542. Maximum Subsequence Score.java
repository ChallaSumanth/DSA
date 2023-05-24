class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
       int len = nums1.length;
       int[][] dict = new int[len][2];
       for(int i = 0; i < len; i++)
            dict[i] = new int[]{nums1[i], nums2[i]};
       Arrays.sort(dict,(a,b) -> b[1] - a[1]);
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       long ans = 0;
       long sum = 0;
       for(int i = 0; i < len; i++)
       {
           sum += dict[i][0];
           minHeap.offer(dict[i][0]);
           if(minHeap.size() > k)
                sum -= minHeap.poll();
           if(i >= k - 1)
                ans = Math.max(ans, sum * dict[i][1]);
       }
        return ans;
    }
}