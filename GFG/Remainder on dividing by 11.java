//https://practice.geeksforgeeks.org/problems/aa8c89caad6b5c3a76ba5e6d65454f77aac3f3543526/1
//Amazon
class Solution 
{ 
    static int xmod11(String x)
	{    
	    // code here
        int cur = 0;
        int rem = 0;
        for(int i = 0; i < x.length(); i++)
        {
            cur = rem * 10 + x.charAt(i) - '0';
            rem = cur % 11;
        }
        return rem;
	}
} 
