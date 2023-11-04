//Google
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for(int dir : left)
            lastMoment = Math.max(lastMoment, dir);
        for(int dir : right)
            lastMoment = Math.max(lastMoment, n - dir);
        return lastMoment;
    }
}