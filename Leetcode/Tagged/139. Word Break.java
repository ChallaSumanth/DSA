//Amazon 34 Facebook 33 Apple 10 Qualtrics 7 Microsoft   5 Bloomberg 5 Oracle 3 Adobe 3 Google 2
//1.recursion
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
    private boolean solve(String s, List<String> wordDict)
    {
        if(wordDict.contains(s))
            return true;
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(wordDict.contains(s.substring(0, i + 1)) && solve(s.substring(i + 1), wordDict))
                return true;
        }
        return false;
    }
}
//2.Memorization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<>();
        return solve(s, wordDict, map);
    }
    private boolean solve(String s, List<String> wordDict, HashMap<String, Boolean> map)
    {
        if(wordDict.contains(s))
            return true;
        if(map.get(s) != null)
            return map.get(s);
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(wordDict.contains(s.substring(0, i + 1)) && solve(s.substring(i + 1), wordDict, map))
            {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
