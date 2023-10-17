class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int [] indegree = new int[n];
        for(int i = 0; i < n; i++)
        {
            if(leftChild[i] != -1) 
                indegree[leftChild[i]]++;
            if(rightChild[i] != -1)
                indegree[rightChild[i]]++;
        }
        int root = -1;
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
            {
                if(root == -1)
                    root = i;
                else
                    return false;
            }
        }
        if(root == -1)
            return false;
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(root);
        boolean[] visited = new boolean[n];
        while(!qu.isEmpty())
        {
            int node = qu.poll();
            if(visited[node])
                return false;
            visited[node] = true;
            if(leftChild[node] != -1) qu.offer(leftChild[node]);
            if(rightChild[node] != -1) qu.offer(rightChild[node]);
        }
        int count = 0;
        for(boolean b : visited)
        {
            if(b) count++;
        }
        return count == n;
    }
}