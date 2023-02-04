class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if(m > n) return false;

        int [] count = freq(s1,m);

        int [] curCount = freq(s2.substring(0,m),m);

        if(areSame(count,curCount))
            return true;
        for(int i = m; i < n; i++)
        {
            curCount[s2.charAt(i - m) - 'a']--;
            curCount[s2.charAt(i) - 'a']++;
            if(areSame(count,curCount))
                return true;
        }
        return false;
    }
    private boolean areSame(int [] count,int[] curCount)
    {
        for(int i = 0; i < 26; i++)
        {
            if(count[i] != curCount[i])
                return false;
        }
        return true;
    }
    private int[] freq(String str,int len)
    {
        int [] count = new int[26];
        for(int i = 0; i < len; i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }
}