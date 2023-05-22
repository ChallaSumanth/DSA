//Medium
class Solution {
    private boolean check(String num, int sum)
    {
        if(sum < 0) return false;
        if(num.equals("") && sum == 0) return true;
        for(int i = 0; i < num.length(); i++)
        {
            String cur = num.substring(0, i + 1);
            String remaining = num.substring(i + 1);
             if(check(remaining, sum - Integer.parseInt(cur)))
               return true;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++)
        { 
            if(check(i * i +"", i))
                ans += i * i;
        }
        return ans;
    }
}