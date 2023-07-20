//zon 14 Facebook 10 DoorDash 7 tiktok 5 Lyft 4 Microsoft 4 Oracle 3 Hotstar 3 Goldman Sachs 3
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int asteroid : asteroids)
        {
            if(asteroid > 0 || st.isEmpty())
                st.push(asteroid);
            else
            {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid))
                    st.pop();
                if(!st.isEmpty() && st.peek() == Math.abs(asteroid))
                    st.pop();
                else{
                    if(st.isEmpty() && asteroid < 0)
                        st.push(asteroid);
                }
            }
        }
        int len = st.size();
        int [] ans = new int[len];
        for(int i = len - 1; i >= 0; i--)
            ans[i] = st.pop();
        return ans;
    }
}