class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for(int weight : weights)
        {
            lo = Math.max(lo,weight);
            hi += weight;
        }
        while(lo < hi)
        {
            int mid = (lo + hi) >> 1;
            if(canPlace(weights,mid,days))
            {
                hi = mid;
            }
            else
                lo = mid + 1;
        }
        return lo;
    }
    private boolean canPlace(int[] weights,int maxCapacity,int days)
    {
        int requiredDays = 1;
        int curWeight = 0;
        for(int weight : weights)
        {
            curWeight += weight;
            if(curWeight > maxCapacity)
            {
                requiredDays++;
                curWeight = weight;
            }
            if(requiredDays > days)
                return false;
        }
        return requiredDays <= days;
    }
}