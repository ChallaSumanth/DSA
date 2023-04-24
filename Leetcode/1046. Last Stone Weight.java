//Visa 11 Nvidia 8 Amazon 4 Salesforce 2
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        for(int stone : stones)
            pq.offer(stone);
        while(pq.size() > 1)
        {
            int x = pq.poll();
            int y = pq.poll();
            if(x == y) continue;
            pq.offer(x - y);
        }
        return pq.isEmpty() == true ? 0 : pq.peek();
    }
}