class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length();
        int [] li = new int[len];
        int count = 0;
        for(int i = 0; i < len; i++)
        {
            if(customers.charAt(i) == 'Y')
                count++;
            else
                count--;
            li[i] = count;
        }
        int max = Integer.MIN_VALUE;
        int temp = len;
        for(int i = len - 1; i >= 0; i--)
        {
            if(max <= li[i])
            {
                max = li[i];
                temp = i + 1;
            }
        }
        if(li[temp - 1] <= 0) return 0;
        return temp;
    }
}