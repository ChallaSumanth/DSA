//https://practice.geeksforgeeks.org/problems/5551749efa02ae36b6fdb3034a7810e84bd4c1a4/1
//paypal

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        boolean[] visited = new boolean[leaves + 1];
        for(int i = 0; i < N; i++)
        {
            int j = frogs[i];
            if(j <= leaves && !visited[j])
            {
                while(j <= leaves)
                {
                    visited[j] = true;
                    j += frogs[i];
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= leaves; i++)
            if(!visited[i]) count++;
        return count;
    }
}
