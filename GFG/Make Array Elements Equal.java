//https://practice.geeksforgeeks.org/problems/1f05c7c12b1084f270c57566b2110967c046730d/1
//Expedia
class Solution {
    public long minOperations(int N) {
        // Code here
        long ans = 0;
        for(int i = N - 1; i >= N/2; i--)
            ans += (2 * i + 1) - N;
        return ans;
    }
}
//optimal
class Solution {
    public long minOperations(int N) {
        // Code here
        long ans = 0;
        
        ans = N / 2;
        ans *= (N + 1) / 2;
        return ans;
    }
}