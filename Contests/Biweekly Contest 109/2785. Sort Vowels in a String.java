class Solution {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        for(char cha : s.toCharArray())
        {
            if(cha == 'A' || cha == 'E' || cha == 'I' || cha == 'O' || cha == 'U' ||
                cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' ||  cha == 'u' )
                list.add(cha);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char cha : s.toCharArray())
        {
            if(cha == 'A' || cha == 'E' || cha == 'I' || cha == 'O' || cha == 'U' ||
                cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' ||  cha == 'u' )
            {
                sb.append(list.get(i));
                i++;
            }
            else
                sb.append(cha);
        }
        return sb.toString();
    }
}