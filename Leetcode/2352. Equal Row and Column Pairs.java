class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int len = grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < len; j++)
            {
                list.add(grid[i][j]);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        for(int i = 0; i < len; i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < len; j++)
            {
                list.add(grid[j][i]);
            }
            count += map.getOrDefault(list, 0);
        }
        return count;
    }
}