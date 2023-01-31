class Sort
{
    int score;
    int age;
    Sort(int age,int score)
    {
        this.age = age;
        this.score = score;
    }
}
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        Sort[] sorted = new Sort[len];
        for(int i=0;i<len;i++)
            sorted[i] = new Sort(ages[i],scores[i]);
        Arrays.sort(sorted,(a,b) -> (a.age == b.age) ? (a.score - b.score ):(a.age - b.age));
        int score = sorted[0].score;
        int [] dp = new int[len];
        dp[0] = sorted[0].score;
        for(int i=1;i<len;i++)
        {
            dp[i] = sorted[i].score;
            for(int j=0;j<i;j++)
            {
                if(sorted[j].score <= sorted[i].score)
                dp[i] = Math.max(dp[i],sorted[i].score+dp[j]);
            }
            score = Math.max(score,dp[i]);
        }
        return score;
    }
}