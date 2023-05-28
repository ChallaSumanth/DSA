class Solution {
    public long minimumCost(String s) {
        long result = 0;
        int len = s.length();
        for(int index = 0; index < len - 1; index++)
        {
            if(s.charAt(index) != s.charAt(index + 1))
                result += Math.min(index + 1, len - index - 1);
        }
        return result;
    }
}