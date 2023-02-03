//Samsung
class Solution{
    static int [] endPoints(int [][]matrix, int R, int C){
        //code here
        int [] ans = new int[2];
        int i = 0,j = 0;
        int dir = 0;
        // 0 - right, 1 - down, 2 - left, 3 - up
        while(i >=0 && i < R && j >= 0 && j < C)
        {
            ans[0] = i;
            ans[1] = j;
            if(matrix[i][j] == 1)
            {
                matrix[i][j] = 0;
                if(dir == 0)
                {
                    dir = 1;
                    i++;
                }
                else if(dir == 1)
                {
                    dir = 2;
                    j--;
                }
                else if(dir == 2)
                {
                    dir = 3;
                    i--;
                }
                else
                {
                    dir = 0;
                    j++;
                }
            }
            else
            {
                if(dir == 0) j++;
                else if(dir == 1) i++;
                else if(dir == 2) j--;
                else i--;
            }
        }
        return ans;
    }
}