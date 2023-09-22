class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        return solve(s, t, 0, 0, slen, tlen) == slen;
    }
    private int solve(String s, String t, int i, int j, int slen, int tlen)
    {
        if(i == slen || j == tlen)
            return 0;
        if(s.charAt(i) == t.charAt(j))
            return 1 + solve(s, t, i + 1, j + 1, slen, tlen);
        else
            return solve(s, t, i, j + 1, slen, tlen);
    }
}