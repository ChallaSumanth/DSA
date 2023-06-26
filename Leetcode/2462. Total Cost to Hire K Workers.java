class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> last = new PriorityQueue<>();
        int i = 0;
        int j = len - 1;
        int hired = 0;
        long ans = 0;
        while(hired != k)
        {
            while(first.size() < candidates && i <= j)
                first.offer(costs[i++]);
            while(last.size() < candidates && i <= j)
                last.offer(costs[j--]);
            
            int cost1 = first.size() > 0 ? first.peek() : Integer.MAX_VALUE;
            int cost2 = last.size() > 0 ? last.peek() : Integer.MAX_VALUE;

            if(cost1 <= cost2)
                ans += first.poll();
            else
                ans += last.poll();
            hired++;
        }
        return ans;
    }
}