class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i = 0; i < len1 - len2 + 1; i++)
        {
            int count = 0;
            while(count < len2 && haystack.charAt(i + count) == needle.charAt(count))
                count++;
            if(count == len2) return i;
        }
        return -1;
    }
}
