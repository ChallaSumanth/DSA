//V.V.V IMP
class Solution
{
    public int CountWays(String str)
    {
        // code here
        if(str.charAt(0) == '0') return 0;
        int len = str.length();
        int [] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;
        for(int i=2;i<=len;i++)
        {
            int onesDigit = Integer.valueOf(str.substring(i-1,i));
            int twosDigit = Integer.valueOf(str.substring(i-2,i));
            
            if(onesDigit >= 1)
                dp[i] += dp[i-1];
            if(twosDigit >= 10 && twosDigit <=26)
                dp[i] += dp[i-2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[len];
    }
}