//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
/*Zoho
Accolite
Amazon
Microsoft
Samsung
MakeMyTrip
Visa
Walmart
Google
Qualcomm
Groupon */
class Solution{
    private  int lo;
    private  int maxLen;
    public String longestPalin(String S){
        // code here
        int len = S.length();
        if(len <= 1) return S;
        for(int i = 0; i < len; i++)
        {
            extendPalindrome(S, i, i);
            extendPalindrome(S, i, i + 1);
        }
        return S.substring(lo, lo + maxLen);
    }
    private  void extendPalindrome(String s, int j, int k)
    {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k))
        {
            j--;
            k++;
        }
        if(maxLen < k - j - 1)
        {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}