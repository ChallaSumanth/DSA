class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int len = dist.length;
        if(hour <= len - 1) return -1;
        int lo = 1;
        int hi = (int) 1e7;
        while(lo < hi)
        {
            int mid = (lo + hi) >> 1;
            double time = 0;
            for(int i = 0; i < len - 1; i++)
                time += Math.ceil((double) dist[i] / mid);
            time += (double)dist[len - 1] / mid;
            if(time <= hour) hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}