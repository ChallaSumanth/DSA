//V.V.V.V.V.V.IMP
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(!st.isEmpty() && s.charAt(i) == ')' && st.peek() == '(')
                st.pop();
            else if(!st.isEmpty() && s.charAt(i) == ']' && st.peek() == '[')
                st.pop();
            else if(!st.isEmpty() && s.charAt(i) == '}' && st.peek() == '{')
                st.pop();
            else
                st.push(s.charAt(i));

        }
        return st.isEmpty();
    }
}