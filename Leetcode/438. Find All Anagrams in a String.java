class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m > n) return ans;
        int [] count = freq(p,m);
        int[] charCount = freq(s.substring(0,m),m);
        if(areSame(count,charCount))
            ans.add(0);
        for(int i = m; i < n; i++)
        {
            charCount[s.charAt(i - m) - 'a']--;
            charCount[s.charAt(i) - 'a']++;
            if(areSame(count,charCount))
                ans.add(i - m + 1);
        }
        return ans;
    }
    private boolean areSame(int [] count,int [] charCount)
    {
        for(int i = 0; i < 26; i++)
        {
            if(count[i] != charCount[i])
                return false;
        }
        return true;
    }
    private int[] freq(String str,int m)
    {
        int [] count = new int[26];
        for(int i = 0; i < m; i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }
}