class DisJointSetUnion
{
   private List<Integer> parent = null;
    DisJointSetUnion(int n)
    {
        parent = new ArrayList<>();
        for(int i=0;i<n;i++)
            parent.add(i);
    }
    public int findUParent(int node)
    {
        if(parent.get(node) == node)
            return node;
        int ul_p = findUParent(parent.get(node));
        parent.set(node,ul_p);
        return parent.get(node);
    }
    public void UnionByLexicographicallySmallest(int u,int v)
    {
        int ul_pu = findUParent(u);
        int ul_pv = findUParent(v);
        if(ul_pu == ul_pv) return;
        if(ul_pu < ul_pv)
            parent.set(ul_pv,ul_pu);
        else
            parent.set(ul_pu,ul_pv);
    }
}
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisJointSetUnion ds = new DisJointSetUnion(26);
        StringBuilder sb = new StringBuilder();
        int len = s1.length();
        for(int i=0;i<len;i++)
        {
            int char1 = s1.charAt(i) - 'a';
            int char2 = s2.charAt(i) - 'a';
            ds.UnionByLexicographicallySmallest(char1,char2);
        }
        for(int i=0;i<baseStr.length();i++)
        {
            int smallestChar = ds.findUParent(baseStr.charAt(i) - 'a');
            sb.append((char)(smallestChar + 'a'));
        }
        return sb.toString();
    }
}