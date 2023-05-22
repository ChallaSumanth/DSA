//Easy
class Solution {
    public String makeSmallestPalindrome(String s) {
        if(isPalindrome(s))
            return s;
        int len = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < len + 1; i++)
            sb1.append(s.charAt(i));
       // System.out.println(sb1.toString());
        int lo = 0;
        int hi = len;
        while(lo < hi)
        {
            int a = s.charAt(lo) - 'a';
            int b = s.charAt(hi) - 'a';
            // System.out.println(s.charAt(lo)+" -- "+a);
            // System.out.println(s.charAt(hi)+" -- "+b);
            if(a == b)
            {
                sb.append(s.charAt(lo));
                lo++;
                hi--;
            }
            else
            {
                // System.out.println(s.charAt(lo)+" -- "+a);
                // System.out.println(s.charAt(hi)+" -- "+b);
                if(a < b)
                {
                    sb.append(s.charAt(lo));
                    sb1.setCharAt(hi, s.charAt(lo));
                    //System.out.println(sb1.toString()+"---");
                    lo++; hi--;
                }
                else
                {
                    sb.append(s.charAt(hi));
                    //System.out.println("yes");
                    lo++; hi--;
                }    
            }
        }
       String str1 = sb1.toString();
       // System.out.println(str1 +"--" +hi);
       if((len+1) % 2 == 0)
           hi += 1;
       sb.append(str1.substring(hi));
        
        return sb.toString();
    }
    private boolean isPalindrome(String str)
    {
        int lo = 0;
        int hi = str.length() - 1;
        while(lo <= hi)
        {
            if(str.charAt(lo) == str.charAt(hi))
            {
                lo++;
                hi--;
            }
            else
                return false;
        }
        return true;
    }
}