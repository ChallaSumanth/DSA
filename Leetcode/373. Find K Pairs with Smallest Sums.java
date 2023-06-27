//LinkedIn 8 Apple 3 Amazon 2 Walmart Global Tech 2 Hotstar 2
//1.brute
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pq 
        = new PriorityQueue<>((a, b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1)));
        for(int i = 0; i < len1; i++)
        {
            for(int j = 0; j < len2; j++)
            {
                pq.offer(Arrays.asList(nums1[i] , nums2[j]));
                if(pq.size() > k) pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }
}
//2.optimal Tc : (k logk) sc: o(k)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq 
        = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for(int i = 0; i < len1; i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !pq.isEmpty())
        {
            int[] cur = pq.poll();
            ans.add(List.of(cur[0], cur[1]));
            if(cur[2] < len2 - 1)
                pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return ans;
    }
}