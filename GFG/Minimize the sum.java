//Swiggy - Easy
class Solution {
    long minimizeSum(int N, int arr[]) {
        // code here
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++)
        {
            pq.offer(arr[i]);
        }
        while(pq.size() > 1)
        {
            int first = pq.poll();
            int second = pq.poll();
            ans += first + second;
            pq.offer(first+second);
        }
        return ans;
    } 
}