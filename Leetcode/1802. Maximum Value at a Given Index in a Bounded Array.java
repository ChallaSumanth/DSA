class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int emptyR = n - index - 1;
        int emptyL = index;
        int lo = 1;
        int hi = maxSum;
        long res = 0;
        while(lo <= hi)
        {
            int mid = (hi - lo) / 2  + lo;
            long leftSum = 0, rightSum = 0, el = mid - 1;
            if(emptyR <= el)
                rightSum = (el * (el + 1)) / 2 - ((el - emptyR) * (el - emptyR + 1)) / 2;
            else
                rightSum = (el * (el + 1)) / 2 + (emptyR - el);
            if(emptyL <= el)
                leftSum = (el * (el + 1)) / 2 - ((el - emptyL) * (el - emptyL + 1)) / 2;
            else
                leftSum = (el * (el + 1)) / 2 + (emptyL - el);
            long sum = leftSum + mid + rightSum;
            if(sum <= maxSum)
            {
                lo = mid + 1;
                res = mid; 
            }
            else
                hi = mid - 1;
        }
        return (int)res;
    }
}