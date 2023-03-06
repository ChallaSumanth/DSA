class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int len = arr.length;
       // System.out.println(len);
        int j = 0;
        for(int i = 1; i <= Integer.MAX_VALUE; i++)
        {
            if(j < len && arr[j] == i)
                j++;
            else
                list.add(i);
           // System.out.println(list);
            if(list.size() == k)
                return list.get(k - 1); 
        }
       // System.out.println(list);
        return k;
    }
}
//2.tc:o(n)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int num : arr)
        {
            if(num <= k) k++;
            else break;
        }
        return k;
    }
}
//3.tc : o(logn)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length;
        while(lo < hi)
        {
            int mid = (lo + hi) >> 1;
            int no_of_missingElements = arr[mid] - (mid + 1);
            if(no_of_missingElements >= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo + k;
    }
}