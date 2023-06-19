class Solution {
    public int largestAltitude(int[] gain) {
        int len = gain.length;
        int[] altitudes = new int[len + 1];
        for(int i = 1; i <= len; i++)
        {
            altitudes[i] =  altitudes[i - 1] + gain[i - 1];
        }
        int highestAlt = Integer.MIN_VALUE;
        for(int alti : altitudes)
            highestAlt = Math.max(highestAlt, alti);
        return highestAlt;
    }

}
//2.optimal
class Solution {
    public int largestAltitude(int[] gain) {
        int len = gain.length;
        int highestAlt = 0;
        int curAlt = 0;
        for(int i = 0; i < len; i++)
        {
            curAlt += gain[i];
            highestAlt = Math.max(highestAlt, curAlt);
        }
        return highestAlt;
    }

}