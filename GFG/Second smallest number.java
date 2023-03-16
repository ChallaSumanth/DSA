//https://practice.geeksforgeeks.org/problems/5c2734730cb1e98e3877a0b91f7d680d0efc8acf/1
//Vmware
class Solution{
    static String secondSmallest(int S, int D){
        // code here
        if(D == 1 || S == 1 || (D * 9 <= S)) return "-1";
        
       int [] arr = new int[D];
        for(int i = 0; i < D - 1; i++)
        {
            if(S > 9)
            {
                arr[i] = 9;
                S -= 9;
            }
            else
            {
                arr[i] = S - 1;
                S = 1;
            }
        }
       arr[D - 1] = S;
       for(int i = 1; i < D; i++)
       {
           if(arr[i] != 9)
           {
               arr[i]++;
               arr[i - 1]--;
               break;
           }
       }
       StringBuilder ans = new StringBuilder();
       for(int i = D - 1; i >= 0; i--)
            ans.append(arr[i]);
       return ans.toString();
    }
}