class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int turn = 1;
        int pos = 0;
        for(int i = 0; i < n; i++)
        {
            pos = pos + (turn * k);
            pos %= n;
            if(visited[pos]) break;
            visited[pos] = true;
            turn++;
        }
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(!visited[i]) temp.add(i + 1);
        int size = temp.size();
        int [] ans = new int[size];
        for(int i = 0; i < size; i++)
            ans[i] = temp.get(i);
        return ans;
    }
}