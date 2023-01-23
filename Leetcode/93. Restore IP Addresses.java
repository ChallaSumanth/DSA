class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restore("",0,0,s,ans);
        return ans;
    }
    private void restore(String path,int index,int dots,String s,List<String> ans)
    {
        if(dots > 4) return;
        if(dots == 4 && index >= s.length())
        {
            ans.add(path.substring(0,path.length()-1));
            return;
        }
        for(int length=1; length <= 3 && length + index <= s.length();length++)
        {
            String num = s.substring(index,length + index);
            if(num.charAt(0) == '0' && length != 1) break;
            else if(Integer.parseInt(num) <= 255)
                restore(path + num + '.',index+length,dots+1,s,ans);
        }
    }
}
