class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int len = words.length;
        String[] words1 = new String[len];
        int count = 0;
        int i =0;
        for(String word : words)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            words1[i] = sb.reverse().toString();
            i++;
        }
        //System.out.println(Arrays.toString(words) +"::" + Arrays.toString(words1));
        boolean[] visited = new boolean[len];
        for(i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
                if(words[i].equals(words1[j]) && !visited[j])
                {
                    visited[j] = true;
                    count++;
                }
        }
        return count;
    }
}