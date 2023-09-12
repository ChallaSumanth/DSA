class Solution {
    public int minDeletions(String s) {
        int len = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < len; i++)
            freq[s.charAt(i) - 'a']++;
        int delCount = 0;
        Set<Integer> set = new HashSet<>();
        for(int count : freq)
        {
            while(count > 0 && set.contains(count))
            {
                count--;
                delCount++;
            }
            set.add(count);
        }
        return delCount;
    }
}