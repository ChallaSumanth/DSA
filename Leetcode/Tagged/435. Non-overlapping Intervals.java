//Facebook 7 Amazon 4 Microsoft 2
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int count = 0;
        int prev = intervals[0][1];
        for(int i = 1; i < len; i++)
        {
            if(intervals[i][0] < prev)
                count++;
            else
                prev = intervals[i][1];
        }
        return count;
    }
}