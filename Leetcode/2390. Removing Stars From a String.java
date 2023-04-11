class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == '*')
            {
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            }
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}