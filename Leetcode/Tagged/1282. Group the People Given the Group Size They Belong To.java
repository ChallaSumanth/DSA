//Apple 2 Bloomberg 2
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            int person = i;
            int groupSize = groupSizes[i];
            List<Integer> group = map.getOrDefault(groupSize, new ArrayList<>());
            group.add(person);
            map.put(groupSize, group);
            if(group.size() == groupSize)
            {
                ans.add(group);
                map.remove(groupSize);
            }
        }
        return ans;
    }
}