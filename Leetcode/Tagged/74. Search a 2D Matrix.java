//Facebook 14 Amazon 12 Microsoft 7 Bloomberg 5 Apple 4 Adobe 3 Goldman Sachs 2 Oracle 2 Nvidia 2 Salesforce 2
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int [] row : matrix)
        {
            int ans = binarySearch(row, target);
            if(ans == target)
                return true;
        }
        return false;
    }
    private int binarySearch(int[] row, int target)
    {
        int lo = 0;
        int hi = row.length - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(row[mid] == target)
                return row[mid];
            else if(row[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}