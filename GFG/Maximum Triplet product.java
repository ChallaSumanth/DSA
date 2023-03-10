//https://practice.geeksforgeeks.org/problems/d54c71dc974b7db3a200eb63f34e3d1cba955d86/1
//Vmware
class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        // Complete the function
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        long max3 = Integer.MIN_VALUE;
        
        long min1 = Integer.MAX_VALUE;
        long min2 = Integer.MAX_VALUE;
        
        for(long value : arr)
        {
            if(value > max1)
            {
                max3 = max2; max2 = max1; max1 = value;
            }
            else if(value > max2)
            {
                max3 = max2;  max2 = value;
            }
            else if(value > max3)
                max3 = value;
            if(value < min1)
            {
                min2 = min1; min1 = value;
            }
            else if(value < min2)
                min2 = value;
        }
        return Math.max(max1 * max2 * max3 , min1 * min2 * max1);
    }
}