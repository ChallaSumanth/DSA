//https://practice.geeksforgeeks.org/problems/2d3fc3651507fc0c6bd1fa43861e0d1c43d4b8a1/1
//sprinklr

class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
        long min_len = Integer.MAX_VALUE;
        long total_perimeter = 0;
        long total_sticks = 0;
        for(int i = 0; i < N; i++)
        {
            if(B[i] % 2 == 1) B[i]--;
            
            if(B[i] >= 2) min_len = Math.min(min_len, A[i]);
            
            total_perimeter += B[i] * A[i];
            
            total_sticks += B[i];
        }
        if(total_sticks % 4 != 0) total_perimeter -= 2 * min_len;
        
        return total_perimeter;
    }
} 