class Solution {
    public int countBeautifulPairs(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                String first_digit = Integer.toString(nums[i]);
                int first = first_digit.charAt(0) - '0';
                int last = nums[j] % 10;
                //System.out.println(first +"::"+last);
                if(gcd(first, last) == 1)
                {
                    //System.out.println(first +"::"+last);
                    count++;
                }
            }
        }
        return count;
    }
    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}