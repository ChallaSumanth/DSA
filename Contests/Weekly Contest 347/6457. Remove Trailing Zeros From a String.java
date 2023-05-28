class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        int index = 0;
        for(int i = len - 1; i >= 0; i--)
        {
            if(num.charAt(i) != '0')
            {
                index = i;
                break;
            }
        }
       // System.out.println(index);
        for(int i = 0; i <= index; i++)
            sb.append(num.charAt(i));
        return sb.toString();
    }
}