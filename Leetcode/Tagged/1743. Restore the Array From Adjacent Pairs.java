//uber
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int [] res = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : adjacentPairs)
        {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        Stack<Integer> st = new Stack<>();
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet())
        {
            if(entry.getValue().size() == 1)
            {
                st.push(entry.getKey());
                break;
            }
        }
        Set<Integer> seen = new HashSet<>();
        int i = 0;
        while(!st.isEmpty())
        {
            int cur = st.pop();
            res[i++] = cur;
            seen.add(cur);
            for(int nei : map.get(cur))
            {
                if(!seen.contains(nei))
                    st.push(nei);
            }
        }
        return res;
    }
}