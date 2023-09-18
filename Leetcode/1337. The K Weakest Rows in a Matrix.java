//1.
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
        (b[1] == a[1] ? b[0] - a[0] :b[1] - a[1]));
        int count = 0;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(mat[i][j] == 1)
                    count++;
            }
            maxHeap.offer(new int[]{i, count});
            if(maxHeap.size() > k)
                maxHeap.poll();
            count = 0;
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--)
            ans[i] = maxHeap.poll()[0];
        return ans;
    }
}
//2.binary search
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
        (b[1] == a[1] ? b[0] - a[0] :b[1] - a[1]));
        for(int i = 0; i < row; i++)
        {
            maxHeap.offer(new int[]{i, getCount(mat[i], col)});
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--)
            ans[i] = maxHeap.poll()[0];
        return ans;
    }
    private int getCount(int[] row, int len)
    {
        if(row[0] == 0)
            return 0;
        else if(row[len - 1] == 1)
            return len;
        else
        {
            int start = 0;
            int end = len - 1;
            while(start < end)
            { 
                int mid = (start + end) >> 1;
                if(row[mid] == 1)
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid;
                }
            }
             return end;
        }
    }
}