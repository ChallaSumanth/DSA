class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] char_map = new int[26];
        for(int i = 0; i < 26; i++)
            char_map[order.charAt(i) - 'a'] = i;
        for(int i = 1; i < words.length; i++)
        {
            if(compare(words[i-1],words[i],char_map) > 0)
                return false;
        }
        return true;
    }
    private int compare(String word1, String word2, int[] char_map)
    {
        int i = 0;
        int j = 0;
        int char_compareVal = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        while(i < len1 && j< len2 && char_compareVal == 0)
        {
            char_compareVal = char_map[word1.charAt(i) - 'a'] - char_map[word2.charAt(j) - 'a'];
            i++;
            j++;
        }
        if(char_compareVal == 0)
            return len1 - len2;
        return char_compareVal;
    }
}