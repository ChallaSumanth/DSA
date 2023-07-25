//Amazon 10 Bloomberg 3 Apple 3 Google 2
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        int len = arr.length;
        for(int i = 1; i < len; i++)
        {
            if(arr[i - 1] < arr[i])
                index = i;
            else
                break;
        }
        return index;
    }
}

//binary sear h
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(arr[mid] < arr[mid + 1])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}