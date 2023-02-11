class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        char arr[] = S.toCharArray();
        int tpov = 0;
        for(int i = 0; i < N - 1; i++)
        {
            if(arr[i] == arr[i+1])
            tpov++;
        }
        if(tpov == 0)
            return 0;
        for(int i = 0; i < N; i++)
        {
            if(P[i] - 1 >= 0 && P[i] - 1 < N && arr[P[i]] == arr[P[i] - 1]) tpov--;
            if(P[i] + 1 >= 0 && P[i] + 1 < N && arr[P[i]] == arr[P[i] + 1]) tpov--;
            
            arr[P[i]] = '?';
            if(tpov == 0)
                return i+1;
        }
     return 0;
    }
}
        
