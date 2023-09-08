//Amazon 5 Apple 4 Microsoft 4 Goldman Sachs 3 Snapchat 2 Uber 2 Yahoo 2
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int line = 1; line <= numRows; line++)
        {
            int c = 1;
            List<Integer> ls = new ArrayList<>();
            for(int i = 1; i <= line; i++)
            {
                ls.add(c);
                c = c * (line - i) / i;
            }
            ans.add(ls);
        }
        return ans;
    }
}
