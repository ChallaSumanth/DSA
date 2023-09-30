class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int len = nums.length;
        int thirdNum = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0; i--)
        {
            if(nums[i] < thirdNum)
                return true;
            while(!st.isEmpty() && st.peek() < nums[i])
                thirdNum = st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}