// 1.Recursion 
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        return solve(n-1,3,points);
    }
    private static int solve(int day,int last,int[][] points)
    {
        if(day == 0)
        {
            int max = 0;
            for(int i=0;i<3;i++)
            {
                if(i != last)
                    max = Math.max(max,points[0][i]);
            }
            return max;
        }
        int max = 0;
         for(int task = 0; task < 3; task++)
            {
                int point = 0;
                if(task != last)
                     point = points[day][task] + solve(day-1,task,points);
                max = Math.max(point,max);
            }
        return max;
    }

}
//2.Memorization
import java.util.Arrays;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [][] dp = new int[n][4];
        for(int i[] :dp) Arrays.fill(i,-1);
        return solve(n-1,3,points,dp);
    }
    static int solve(int day,int last,int[][] points,int[][] dp)
    {
        if(dp[day][last] != -1)
            return dp[day][last];
        if(day == 0)
        {
            int max = 0;
            for(int i=0;i<3;i++)
            {
                if(i != last)
                    max = Math.max(max,points[0][i]);
            }
            return dp[day][last] = max;
        }
        int max = 0;
         for(int task = 0; task < 3; task++)
            {
                if(task != last)
                {
                    int point = points[day][task] + solve(day-1,task,points,dp);
                    max = Math.max(max,point);
                }
            }
        return dp[day][last] = max;
    }

}
//3.Tabulation
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        
        for(int day = 1; day < n; day++)
        {
            for(int last = 0;last < 4; last++)
            {
                dp[day][last] = 0;
                for(int task = 0; task < 3; task++)
                {
                    if(last != task)
                    {
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

}
4.Space optimization
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [] dp = new int[4];
        dp[0] = Math.max(points[0][1],points[0][2]);
        dp[1] = Math.max(points[0][0],points[0][2]);
        dp[2] = Math.max(points[0][0],points[0][1]);
        dp[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        
        for(int day = 1; day < n; day++)
        {
            int [] temp = new int[4];
            for(int last = 0;last < 4; last++)
            {
                for(int task = 0; task < 3; task++)
                {
                    if(last != task)
                    {
                        temp[last] = Math.max(temp[last],points[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }

}