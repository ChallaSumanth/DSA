//https://practice.geeksforgeeks.org/problems/13eb74f1c80bc67d526a69b8276f6cad1b8c3401/1
//facebook
class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        if(S.equals(T)) return 1;
        int len1 = S.length();
        int len2 = T.length();
        int i = 0, j = 0;
        while(i < len1 && j < len2)
        {
            if(Character.isDigit(T.charAt(j)))
            {
               int count = 0;
               while(j < len2 && Character.isDigit(T.charAt(j)))
               {
                   count = count * 10 + T.charAt(j) - '0';
                   j++;
               }
               i += count;
            }
           else if(S.charAt(i) == T.charAt(j))
            {
                i++;
                j++;
            }
            else if(S.charAt(i) != T.charAt(j))
            {
                return 0;
            }
        }
        if(i == len1 && j == len2) return 1;
        return 0;
    }
}