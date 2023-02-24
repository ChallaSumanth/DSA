
//tc : O(NlogNlogM)
//sc : O(n)
class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int num : nums)
        {
            if(num % 2 == 0)
                ts.add(num);
            else
                ts.add(num * 2);
        }
        int diff = Integer.MAX_VALUE;
        while(true)
        {
            int minVal = ts.first();
            int maxVal = ts.last();
            diff = Math.min(diff,maxVal - minVal);
            if(maxVal % 2 == 0)
            {
                ts.remove(maxVal);
                ts.add(maxVal / 2);
            }
            else
              return diff;
        }
    }
}