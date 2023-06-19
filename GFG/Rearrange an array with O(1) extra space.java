//https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1
//Amazon
//1.SC:O(N)
class Solution
{
 
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long arr[], int n)
    {
        // your code here
        long arr1[] = new long[n];
        for(int i = 0; i < n; i++)
            arr1[i] = arr[i];
        for(int i = 0; i < n; i++)
        {
            long y = arr1[i];
            arr[i] = arr1[(int)y];
        }
    }
}
//2.optimal
class Solution
{
 
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long arr[], int n)
    {
        // your code here
        for(int i = 0; i < n; i++)
        {
            arr[i] += (arr[(int)arr[i]] % n) * n;
        }
        for(int i = 0; i < n ;i++)
            arr[i] /= n;
    }
}