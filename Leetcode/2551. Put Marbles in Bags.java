class Solution {
    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        List<Integer> sort = new ArrayList<>();
        for(int i = 1; i < len; i++)
            sort.add(weights[i - 1] + weights[i]);
        Collections.sort(sort);
        long max = 0;
        long min = 0;
        for(int i = 0; i < k - 1; i++)
        {
            min += sort.get(i);
            max += sort.get(len - 2 - i);
        }
        return max - min;
    }
}