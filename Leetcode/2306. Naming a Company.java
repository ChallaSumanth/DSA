class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] suffixesByLetter = new HashSet[26];
        for(int i = 0; i < 26; i++)
            suffixesByLetter[i] = new HashSet<>();
        for(String idea : ideas)
            suffixesByLetter[idea.charAt(0) - 'a'].add(idea.substring(1));
        long pairs = 0;
        for(int i = 0; i < 26; i++)
        {
            for(int j = i + 1; j < 26; j++)
            {
                int overlaps = 0;
                for(String str : suffixesByLetter[i])
                {
                    if(suffixesByLetter[j].contains(str))
                        overlaps++;
                }
                 pairs += (suffixesByLetter[i].size() - overlaps) * (suffixesByLetter[j].size() - overlaps) * 2;
            }
        }
        return pairs;
    }
}