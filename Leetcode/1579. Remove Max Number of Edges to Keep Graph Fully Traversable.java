class DisJointSetUnion
{
   private int[] parent;
   private int[] rank;
   public DisJointSetUnion(int n)
   {
       parent = new int[n];
       rank = new int[n];
       for(int i = 0; i < n; i++)
        parent[i] = i;
   }
   public int findUParent(int node) 
   {
       return parent[node] == node ? parent[node] : findUParent(parent[node]);
   }
   public boolean UnionByRank(int u, int v)
   {
       int ul_pu = findUParent(u);
       int ul_pv = findUParent(v);
       if(ul_pu != ul_pv)
       {
           if(rank[ul_pu] < rank[ul_pv])
                parent[ul_pu] = ul_pv;
           else if(rank[ul_pu] > rank[ul_pv])
                parent[ul_pv] = ul_pu;
            else
            {
                parent[ul_pu] = ul_pv;
                rank[ul_pv]++;
            }
            return true;
       }
       return false;
   } 
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
       Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
       DisJointSetUnion Alice = new DisJointSetUnion(n + 1);
       DisJointSetUnion Bob = new DisJointSetUnion(n + 1);
       int removed_count = 0;
       int alice_edge = 0;
       int bob_edge = 0;
       for(int [] edge : edges)
       {
           if(edge[0] == 3)
           {
               if(Alice.UnionByRank(edge[1], edge[2]))
               {
                   Bob.UnionByRank(edge[1], edge[2]);
                   alice_edge++;
                   bob_edge++;
               }
               else
                removed_count++;  
           }
           else if(edge[0] == 2)
           {
               if(Bob.UnionByRank(edge[1], edge[2]))
                    bob_edge++;
               else
                  removed_count++;
           }
           else
           {
               if(Alice.UnionByRank(edge[1], edge[2]))
                    alice_edge++;
                else
                    removed_count++;
           }
       }
       if(alice_edge == n - 1 && bob_edge == n - 1) return removed_count;
       return -1;
    }
}