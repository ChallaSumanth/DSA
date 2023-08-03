//Amazon 28 Microsoft 20 Facebook 14 Uber 9 Apple 7 Google 5 Bloomberg 5 Epic Systems 3 Swiggy 3
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0 || digits == null) return ans;
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d' , 'e' , 'f'}, {'g', 'h', 'i'},
                        {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                        {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        Combinations(0, digits, new StringBuilder(), ans, map);
        return ans;
    }
    private void Combinations(int start, String digits, StringBuilder sb, List<String> ans, char[][] map)
    {
        if(start == digits.length())
        {
            ans.add(sb.toString());
            return;
        }
        int index = digits.charAt(start) - '0';
        for(int i = 0; i < map[index].length; i++)
        {
            sb.append(map[index][i]);
            Combinations(start + 1, digits, sb, ans, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
