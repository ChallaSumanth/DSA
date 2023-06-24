class Solution {
    public int longestString(int x, int y, int z) {
        if(x == 1 && y == 1 && z == 1)
            return 6;
        int xyz = Math.min(x, y);
        int p = x;
        int q = y;
        int r = z;
        if(x == y)
            return 4 * p + r * 2;
        else
            return (2 * xyz + 1 + r) * 2;
    }
}