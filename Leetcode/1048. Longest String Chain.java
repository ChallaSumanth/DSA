class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(String word : words)
        {
            map.put(word, 1);
            for(int i = 0; i < word.length(); i++)
            {
                String newWord = word.substring(0, i) + word.substring(i + 1);

                if(map.containsKey(newWord))
                    map.put(word, Math.max(map.get(word), map.get(newWord) + 1));
            }
             ans = Math.max(ans, map.get(word));
        }
        return ans;
    }
}