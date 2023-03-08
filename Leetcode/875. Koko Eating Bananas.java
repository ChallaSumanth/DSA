class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1000000000;

        while(lo < hi)
        {
            int mid = lo +(hi - lo ) / 2;
            if(canEatInTime(piles, mid , h)) hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
    private boolean canEatInTime(int [] piles, int k, int h)
    {
        int hours = 0;
        for(int pile : piles)
        {
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}