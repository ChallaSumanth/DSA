//https://practice.geeksforgeeks.org/problems/a7a4da81b20f4a05bbd93f5786fcf7478298f4f5/1
//amdocs
// tc: o(long(min(L,B)))
class Solution{
    static List<Long> minimumSquares(long L, long B)
    {
        // code here
        List<Long> ans = new ArrayList<>();
        
        long len = gcd(L,B);
        
        long no_of_sqrs = (L * B) / (len * len);
        
        ans.add(no_of_sqrs);
        ans.add(len);
        
        return ans;
    }
    private static long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}