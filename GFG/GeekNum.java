class Solution {
    static long solve(int N, int K, ArrayList<Long> GeekNum) {
        //code here
        long total = 0;
        for(int i = 0; i < K; i++)
            total += GeekNum.get(i);
        int start = 0;
        for(int i = K; i < N; i++)
        {
            GeekNum.add(total);
            total += total;
            total -= GeekNum.get(start);
            start++;
        }
        return GeekNum.get(N - 1);
    }
}