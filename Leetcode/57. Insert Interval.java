// java guides
//Techinfo YT

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new LinkedList<>();
        for(int [] interval : intervals)
        {
            if(newInterval[1] < interval[0])
            {
                merged.add(newInterval);
                newInterval = interval;
            }
            else if(interval[1] < newInterval[0])
            {
                merged.add(interval);
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0],interval[0]);
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
        }
        merged.add(newInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}