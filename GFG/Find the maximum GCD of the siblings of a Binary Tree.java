//return root of those siblings  //Samsung

class Solution {
    int maxGCD(Node root) {
        // code here 
        int [] max_gcd = new int[1];
        int [] ans = new int[1];
        dfs(root,max_gcd,ans);
        return ans[0];
    }
    private int dfs(Node root,int[] max_gcd,int [] ans)
    {
        if(root == null) return 0;
        int left = dfs(root.left,max_gcd,ans);
        int right = dfs(root.right,max_gcd,ans);
        if(left != 0 && right != 0)
        {
            int gcd = GCD(left,right);
            if(gcd > max_gcd[0])
            {
                max_gcd[0] = gcd;
                ans[0] = root.data;
            }
            if(gcd == max_gcd[0])
            {
                ans[0] = Math.max(ans[0],root.data);
            }
        }
        return root.data;
    }
    private int GCD(int a,int b)
    {
        if(b == 0) return a;
        return GCD(b,a%b);
    }
}