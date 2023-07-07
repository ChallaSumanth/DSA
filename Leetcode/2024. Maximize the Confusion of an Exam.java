//Amazon 2
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0;
        int len = answerKey.length();
        int consecCount = 0, ans = 0;
        for(int i = 0; i < len; i++)
        {
            if(answerKey.charAt(i) == 'F')
                consecCount++;
            while(consecCount > k)
            {
                if(answerKey.charAt(start) == 'F')
                    consecCount--;
                start++;
            }
            ans = Math.max(ans, i - start + 1);
        }
        consecCount = 0;start = 0;
        for(int i = 0; i < len; i++)
        {
            if(answerKey.charAt(i) == 'T')
                consecCount++;
            while(consecCount > k)
            {
                if(answerKey.charAt(start) == 'T')
                    consecCount--;
                start++;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}