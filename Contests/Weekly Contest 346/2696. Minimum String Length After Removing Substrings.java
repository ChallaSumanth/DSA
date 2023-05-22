//Easy
class Solution {
    public int minLength(String s) {
     Stack<Character> st = new Stack<>();   
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(!st.isEmpty() && st.peek() == 'A' && s.charAt(i) == 'B')
                st.pop();
            else if(!st.isEmpty() && st.peek() == 'C' && s.charAt(i) == 'D')
                st.pop();
            else
                st.push(s.charAt(i));
        }
        return st.size();
    }
}