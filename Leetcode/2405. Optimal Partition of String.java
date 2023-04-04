class Solution {
    public int partitionString(String s) {
        int [] freq = new int[26];
        int partition = 1;
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(freq[s.charAt(i) - 'a'] != 0)
            {
                partition++;
                Arrays.fill(freq, 0);
            }
            freq[s.charAt(i) - 'a']++;
        }
        return partition;
    }
}