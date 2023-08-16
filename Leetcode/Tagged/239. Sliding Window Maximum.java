//Amazon 32 Google 8 Microsoft 6 Salesforce 6 Uber 5 Facebook 5 Adobe 4 Citadel 4 ByteDance 4 Apple 3 Twilio 3 tiktok 3 Bloomberg 2
//VMware 2 Booking.com 2 DoorDash 2 DE Shaw 2 Quora 2
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int [] ans = new int[len - k + 1];
        int ind = 0;
        Deque<Integer> dqu = new ArrayDeque<>();
        for(int i = 0; i < len; i++)
        {
            if(!dqu.isEmpty() && dqu.peek() == i - k)
                dqu.poll();
            while(!dqu.isEmpty() && nums[dqu.peekLast()] < nums[i])
                dqu.pollLast();
            dqu.offer(i);
            if(i >= k - 1)
                ans[ind++] = nums[dqu.peek()];
        }
        return ans;
    }
}
