class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        int i = 0;
        int index = 0;
        while(i < len)
        {
           int j = i;
            while(j < len && chars[i] == chars[j])
                j++;
            chars[index++] = chars[i];
            if(j - i > 1)
            {
                String count = j - i +"";
                for(char c : count.toCharArray())
                    chars[index++] = c;
            }
            i = j;
        }
        return index;
    }
    
}