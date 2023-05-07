//Microsoft
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        List<Integer> lis = new ArrayList<>();
        int [] ans = new int[len];
        for(int i = 0; i < len; i++)
        {
            if(lis.size() == 0 || lis.get(lis.size() - 1) <= obstacles[i])
            {
                lis.add(obstacles[i]);
                ans[i] = lis.size();
            }
            else
            {
                int index = binarySearch(obstacles[i], lis, 0, lis.size() - 1);
                lis.set(index, obstacles[i]);
                ans[i] = index + 1;
            }
        }
        return ans;
    }
    private int binarySearch(int ele, List<Integer> lis, int lo, int hi)
    {
        int ans = -1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(lis.get(mid) <= ele)
                lo = mid + 1;
            else
            {
                hi = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}