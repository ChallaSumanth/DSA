//https://practice.geeksforgeeks.org/problems/77e1c3e12cd148f835d53eb168d4472b2ff539fa/1
//Swiggy - easy

//1.brute
class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        int maxCount = 0;
        int rowNumber = 0;
        int temp = 0;
        int i = 0;
        for(int [] ma : mat)
        {
            int count = 0;
            for(int num : ma)
            {
                if(num == 1)
                    count++;
            }
            if(count > temp)
            {
                temp = count;
                maxCount = temp;
                rowNumber = i;
            }
            i++;
        }
        return new int[]{rowNumber,maxCount};
    }
};
//2.optimal
class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        int j = N - 1;
        int row = 0;
        for(int i = 0; i < N; i++)
        {
            while(j >= 0 && mat[i][j] == 1)
            {
                row = i;
                j--;
            }
        }
        return new int[]{row, N - j - 1};
    }
};