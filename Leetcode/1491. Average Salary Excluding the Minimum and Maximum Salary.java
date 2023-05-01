// Amazon 2 Netsuite 1
class Solution {
    public double average(int[] salary) {
        int len = salary.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double total = 0;
        for(int i = 0; i < len; i++)
        {
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
            total += salary[i];
        }
        return (total - min - max) / (len - 2);
    }
}