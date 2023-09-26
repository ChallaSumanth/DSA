class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if(len == 1)
            return s;
        int[] lastIndex = new int[26];
        for(int i = 0; i < len; i++)
            lastIndex[s.charAt(i) - 'a'] = i;
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++)
        {
            int cur = s.charAt(i) - 'a';
            if(seen[cur])
                continue;
            while(!st.isEmpty() && st.peek() > cur && i < lastIndex[st.peek()])
                seen[st.pop()] = false;
            st.push(cur);
            seen[cur] = true;
        }
        while(!st.isEmpty())
            sb.append((char)(st.pop() + 97));
        return sb.reverse().toString();
    }
}