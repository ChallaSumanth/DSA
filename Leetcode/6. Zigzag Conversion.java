class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb =new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();
        int i = 0;
        int len = s.length();
        while(i < len)
        {
            for(int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(s.charAt(i++));
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(s.charAt(i++));
        }
        for(i = 1; i < numRows; i++)
            sb[0].append(sb[i]);
        return sb[0].toString();
    }
}