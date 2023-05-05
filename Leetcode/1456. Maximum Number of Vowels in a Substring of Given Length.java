class Solution {
    public int maxVowels(String s, int k) {
        int len = s.length();
        int vowels = 0;
        for(int i = 0; i < k; i++)
        {
            if(isVowel(s.charAt(i)))
                vowels++;
        }
        if(k == len) return vowels;
        int temp = vowels;
        int start = 0;
        for(int i = k; i < len; i++)
        {
            if(isVowel(s.charAt(start)))
                temp--;
            if(isVowel(s.charAt(i)))
                temp++;
            start++;
            vowels = Math.max(vowels, temp);
        }
        return vowels;
    }
    private boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}