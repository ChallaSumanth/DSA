class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
        
        //n = 13
        //arr = 1 2 0 6 -10 4 3 -1 1 2 -3 3 6
        int ans = 0;
        int count_of_neg = 0;
        int negativeIdx = -1;
        int start = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == 0)
            {
                start = i + 1;
                count_of_neg = 0;
                negativeIdx = -1;
            }
            if(arr[i] < 0)
            {
                count_of_neg++;
                if(negativeIdx == -1)
                    negativeIdx = i;
            }
            if(count_of_neg % 2 == 1)
            {
                ans = Math.max(Math.max(ans,negativeIdx - start),i - negativeIdx);
            }
            else
                ans = Math.max(ans,i - start + 1);
        }
        return ans;
    }
   
}