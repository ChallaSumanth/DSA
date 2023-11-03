class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> ans = new ArrayList<>();
        int curNum = 1;
        int curIdx = 0;
        while(curNum <= n && curIdx < len)
        {
            if(curNum == target[curIdx])
            {
                ans.add("Push");
                curIdx++;
            }
            else
            {
                ans.add("Push");
                ans.add("Pop");
            }
            curNum++;
        }
        return ans;
    }
}