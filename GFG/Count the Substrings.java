//https://practice.geeksforgeeks.org/problems/839d6ba2c2e4c669ba9d9d9f32ad20118937284e/1
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int len = S.length();
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < len; i++)
        {
            if(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') sum++;
            else sum--;
            if(sum == 0) ans++;
            if(map.containsKey(sum))
            {
                ans += map.get(sum);
                map.put(sum, map.get(sum)+1);
            }
            else
                map.put(sum, 1);
        }
        return ans;
    }
} 
