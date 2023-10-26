class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int len = arr.length;
        if(len == 1)
            return 1;
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            long count = 1;
            for(int j = 0; j < i; j++)
            {
                if(arr[i] % arr[j] == 0 && map.containsKey(arr[i]/arr[j]))
                    count += map.get(arr[j]) * map.get(arr[i]/arr[j]);
            }
            map.put(arr[i], count);
        }
        long ans = 0;
        for(long val : map.values())
            ans += val;
        return (int)(ans % 1000000007);
    }
}