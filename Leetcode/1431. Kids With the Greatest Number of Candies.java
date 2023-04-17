//Amazon 3
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int candi : candies)
            max = Math.max(max, candi);
        for(int candi : candies)
            result.add(extraCandies + candi >= max);
        return result;
    }
}