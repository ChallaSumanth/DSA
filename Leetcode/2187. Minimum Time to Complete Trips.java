class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 1;
        long hi = (long)1e14;
        while(lo < hi)
        {
            long mid = lo + (hi - lo) / 2;

            if(numberOfTripsForGivenTime(time , mid, totalTrips))
                hi = mid;
            else
                lo = mid + 1;            
        }
        return lo;
    }
    private boolean numberOfTripsForGivenTime(int [] times, long givenTime, int maxTrips)
    {
        long totalTrips = 0;
        for(int time : times)
        {
            totalTrips += (givenTime / time);
        }
        return totalTrips >= maxTrips;
    }
}