class Solution {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++)
            res[i] = countBit(arr[i]) * 10001 + arr[i];
        Arrays.sort(res);
        for(int i = 0; i < len; i++)
            res[i] %= 10001;
        return res;
    }
    private int countBit(int n)
    {
        int count = 0;
        while(n != 0)
        {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}