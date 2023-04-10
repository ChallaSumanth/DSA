//https://practice.geeksforgeeks.org/problems/63c232252d445a377e01cd91adfd7d1060580038/1
//swiggy
class Solution {
    public int maxIntersections(int[][] lines, int N) {
        // Code here
        Map<Integer, Integer> map = new TreeMap<>();
        for(int [] line : lines)
        {
            map.put(line[0], map.getOrDefault(line[0], 0) + 1);
            map.put(line[1] + 1, map.getOrDefault(line[1] + 1, 0) - 1);
        }
        int sum = 0;
        int ans = 1;
        for(int key : map.keySet())
        {
            sum += map.get(key);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}