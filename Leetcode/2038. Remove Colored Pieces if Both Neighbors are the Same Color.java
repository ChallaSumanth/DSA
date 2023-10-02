//Contest
class Solution {
    public boolean winnerOfGame(String colors) {
        int aCnt = 0, bCnt = 0;
        int aTemp = 0, bTemp = 0;
        int len = colors.length();
        for(int i = 0; i < len; i++)
        {
            if(colors.charAt(i) == 'A')
            {
                bTemp = 0;
                aTemp += 1;
                if(aTemp >= 3)
                    aCnt++;
            }
            else
            {
                aTemp = 0;
                bTemp += 1;
                if(bTemp >= 3)
                    bCnt++;
            }
        }
        return aCnt > bCnt;
    }
}