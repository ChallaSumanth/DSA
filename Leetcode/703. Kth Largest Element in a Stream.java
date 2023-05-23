//Amazon 4 Google 4 Adobe 4 Facebook 3 LinkedIn 2
class KthLargest {

    private PriorityQueue<Integer>pq = null;
    private int size = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.size = k;
        for(int num : nums)
            add(num);
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > size)
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
