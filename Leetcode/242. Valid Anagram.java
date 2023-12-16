class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++)
            freq[s.charAt(i) - 'a']++;
        len = t.length();
        for(int i = 0; i < len; i++)
        {
            freq[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++)
            if(freq[i] != 0)
                return false;
        return true;
    }
}