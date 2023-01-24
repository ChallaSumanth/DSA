// GS Microsoft
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> curLevel = new LinkedList<>();
        curLevel.offer(1);
        visited.add(1);
        int steps = 0;
        while(!curLevel.isEmpty())
        {
            Queue<Integer> nextLevel = new LinkedList<>();
            while(!curLevel.isEmpty())
            {
                int node = curLevel.poll();
                for(int i = node+1 ;i <= Math.min(node+6,target); i++)
                {
                    int next = getAt(board,i);
                    if(next == -1) next = i;
                    if(visited.contains(next))
                        continue;
                    if(next == target)
                        return steps + 1;
                    nextLevel.add(next);
                    visited.add(next);
                }
            }
            steps++;
            curLevel = nextLevel;
        }
        return -1;
    }
    private int getAt(int [][] board,int cur)
    {
        cur = cur - 1;
        int rowOffSet = cur/board.length;
        int row = (board.length - 1) - rowOffSet;
        int col = rowOffSet % 2 == 0 ? cur % board.length
         : (board.length - 1) - (cur % board.length);
         return board[row][col];
    }
}