//Google
class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();
        return solve(s1, s2, map);
    }
    private boolean solve(String s1, String s2, Map<String, Boolean> map )
    {
        int len = s1.length();
        if(s1.equals(s2)) return true;
        if(len == 1) return false;
        int[] freq = new int[26];
        for(char c: s1.toCharArray())
            freq[c - 'a']++;
        for(char c : s2.toCharArray())
            freq[c - 'a']--;
        for(int i = 0; i < 26; i++)
        {
            if(freq[i] != 0) return false;
        }
        String key = s1 +" "+s2;
        if(map.containsKey(key)) return map.get(key);
        for(int i = 1; i < len; i++)
        {
            if(solve(s1.substring(0, i), s2.substring(0 , i), map) 
             && solve(s1.substring(i), s2.substring(i), map))
             {
                 map.put(key, true);
                 return map.get(key);
             }
             if(solve(s1.substring(0, i), s2.substring(len - i), map)
              && solve(s1.substring(i), s2.substring(0, len - i), map))
              {
                  map.put(key, true);
                  return map.get(key);
              }
        }
        map.put(key, false);
        return map.get(key);
    }
}