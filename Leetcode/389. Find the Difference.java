//1.class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        int slen = s.length();
        int tlen = t.length();
        for (int i = 0; i < slen; i++)
            freq[s.charAt(i) - 'a']++;
        for(int i = 0; i < tlen; i++)
        {
            freq[t.charAt(i) - 'a']--;
            if (freq[t.charAt(i) - 'a'] == -1)
              return  t.charAt(i);
        }
        return 'a';
    }
}
//2.
class Solution {
    public char findTheDifference(String s, String t) {
      char x=0;
        for(char st1:s.toCharArray())
            x^=st1;
        for(char st2:t.toCharArray())
            x^=st2;
        return x;
    }
}