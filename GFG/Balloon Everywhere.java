class Solution {
    public int maxInstance(String s) {
        // Code here
        int [] count = new int[26];
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(count[0],Math.min(count[1],count[13]));
        if(ans == 1) return 1;
        if(count[11] >=  2  && count[14] >= 2)
        {
            count[11] /= 2;
            count[14] /= 2;
            return Math.min(count[11],count[14]);
        }
        return 0;
    }
}