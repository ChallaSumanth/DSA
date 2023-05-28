class Solution {
    public int buyChoco(int[] prices, int money) {
        int count = 0;
        Arrays.sort(prices);
        int sum = 0;
        for(int i = 0; i < prices.length; i++)
        {
            if(sum < money && count < 2)
            {
                sum += prices[i];
                count++;
            }
            if(count == 2 || sum > money)
                break;
        }
        if(sum > money || sum == 0 || count != 2) return money;
        return money - sum;
    }
}