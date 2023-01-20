
//JUSPAY
class Solution{
    public int maxWeightCell(int N, int Edge[]){
       
       int weight[] = new int[N];
       for(int i=0;i<N;i++)
       {
           if(Edge[i] != -1)
           weight[Edge[i]] += i;
       }
       int max_wt = -1;
       int max_wt_index = -1;
       for(int i=0;i<N;i++)
       {
           if(weight[i] >= max_wt)
           {
               max_wt = weight[i];
               max_wt_index = i;
           }
       }
       return max_wt_index;
    }
}