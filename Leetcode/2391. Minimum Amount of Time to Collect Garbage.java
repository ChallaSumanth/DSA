//Microsoft
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;
        int M_idx = 0;
        int P_idx = 0;
        int G_idx = 0;
        int totalTime = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < garbage[i].length(); j++)
            {
                if(garbage[i].charAt(j) == 'M')
                    M_idx = i;
                else if(garbage[i].charAt(j) == 'P')
                    P_idx = i;
                else
                    G_idx = i;
                totalTime++;
            }
        }
        for(int i = 1; i < travel.length; i++)
            travel[i] += travel[i - 1];
        totalTime += M_idx > 0 ? travel[M_idx - 1] : 0;
        totalTime += P_idx > 0 ? travel[P_idx - 1] : 0;
        totalTime += G_idx > 0 ? travel[G_idx - 1] : 0;
        return totalTime;
    }
}