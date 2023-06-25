class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        int len = positions.length;
        Integer[] index = new Integer[len];
        for(int i = 0; i < len; i++)
            index[i] = i;
        Arrays.sort(index, (a, b) -> (positions[a] - positions[b]));
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++)
        {
            if(directions.charAt(index[i]) == 'L')
            {
                while(!st.isEmpty() && healths[index[i]] > 0)
                {
                    if(healths[st.peek()] > healths[index[i]])
                    {
                        healths[index[i]] = 0;
                        healths[st.peek()]--;
                    }
                    else if(healths[st.peek()] < healths[index[i]])
                    {
                         healths[index[i]]--;
                        healths[st.pop()] = 0;
                    }
                    else
                    {
                        //System.out.println(healths[index[i]] + ":::" + healths[st.pop()]);
                        healths[index[i]] = 0;
                        healths[st.pop()] = 0;
                    }
                }
            }
            else
                st.push(index[i]);
        }
        for(int health : healths)
        {
            if(health > 0)
                ans.add(health);
        }
        return ans;
    }
}