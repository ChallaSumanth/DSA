//Amazon 31 Facebook 30 Microsoft 24 LinkedIn 17 Apple 7 Bloomberg 7 Adobe 7 ByteDance 6 Walmart Global Tech 5
//Oracle 5 tiktok 4 VMware 3 Google 3 Visa 3 ServiceNow 3 Expedia 2 Nvidia 2 Salesforce 2 Goldman Sachs 2 Morgan Stanley 2 Splunk 2
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(nums[mid] == target) 
                return mid;
            if(nums[lo] <= nums[mid])
            {
                if(nums[lo] <= target && target <= nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            if(nums[mid] <= nums[hi])
            {
                if(target >= nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1; 
            }
        }
        return -1;
    }
}
