//https://practice.geeksforgeeks.org/problems/38f100615d0b2efa755e7b07f905e0f8cd2fe5df/1
//ola
class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int ans = 0;
        int orange = 0;
        int j = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr.charAt(i) == 'O') orange++;
            while(orange > m)
            {
                if(arr.charAt(j) == 'O') orange--;
                j++;
            }
            ans = Math.max(ans,i - j + 1);
        }
        return ans;
    }
}
