class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int ele : arr)
        {
           if(!st.isEmpty())
           {
               if((st.peek() >= 0 && ele < 0) || (st.peek() < 0 && ele >= 0))
                    st.pop();
               else
                    st.push(ele);
           }
           else
                st.push(ele);
        }
        while(!st.isEmpty())
            ans.add(st.pop());
        Collections.reverse(ans);
        return ans;
    }
}