//Facebook 162 Amazon 9 Bloomberg 8 LinkedIn 7 Google 5 Microsoft 5 Apple 5 Adobe 3 Yahoo 3
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long num = n;
        if(num < 0)
            num = -num;
        while(num > 0)
        {
            if(num % 2 == 1)
            {
                res = res * x;
                num = num - 1;
            }
            else if(num % 2 == 0)
            {
                x = x * x;
                num /= 2;
            }
        }
        return n < 0 ? 1 / res : res;
    }
}