//flipkart
class Solution {
    public int maxCoins(int[] piles) {
        int len = piles.length;
        Arrays.sort(piles);
        int maxCoins = 0;
        for(int i = len / 3; i < len; i += 2)
        {
            maxCoins += piles[i];
        }
        return maxCoins;
    }
}