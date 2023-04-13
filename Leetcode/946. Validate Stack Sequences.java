//Amazon 4 Microsoft 2 TickTok 2
//1.TC : O(N) SC : O(N)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int val : pushed)
        {
            st.push(val);
            while(!st.isEmpty() && st.peek() == popped[j])
            {
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
//2.TC:O(N) sc:O(1)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        for(int val : pushed)
        {
            pushed[i++] = val;
            while(i > 0 && pushed[i - 1] == popped[j])
            {
                j++;
                i--;
            }
        }
        return i == 0;
    }
}