//https://practice.geeksforgeeks.org/problems/00ae30d0e0f6d8877c68f8b8558c5b0138fdb4b7/1
//Accolite Microsoft
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        
        int maxi = 0;
        for(int i = 0; i < n; i++)
            maxi = Math.max(maxi, arr[i].deadline);
        int [] result = new int[maxi + 1];
        Arrays.fill(result, -1);
        int maxProfit = 0;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = arr[i].deadline; j > 0; j--)
            {
                if(result[j] == -1)
                {
                    result[j] = i;
                    maxProfit += arr[i].profit;
                    count++;
                    break;
                }
            }
        }
        return new int[]{count, maxProfit};
    }
}