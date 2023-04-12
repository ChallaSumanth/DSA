//Facebook 112 Amazon 8 Google 5 Apple 3
class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String s[] = path.split("/");
        for(String dirOrFile : s)
        {
           if(!st.isEmpty() && dirOrFile.equals(".."))
                st.pop();
           else if(!dirOrFile.equals("") && !dirOrFile.equals("..") && !dirOrFile.equals("."))
                st.push(dirOrFile);
        }
        if(st.isEmpty()) return "/";
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
            ans.insert(0,st.pop()).insert(0,"/");
        return ans.toString();
    }
}