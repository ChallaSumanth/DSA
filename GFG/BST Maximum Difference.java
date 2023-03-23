//https://practice.geeksforgeeks.org/problems/e841e10213ddf839d51c2909f1808632a19ae0bf/1

class Solution
{
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        solve(root, target, 0, 0, false, ans);
        if(ans[0] == Integer.MIN_VALUE) return -1;
        return ans[0];
    }
    private static void solve(Node root,  int target,int to_target, int to_leaf, boolean found, int[] ans)
    {
        if(root == null) return;
        if(root.data == target) found = true;
        if(found)
        {
            to_leaf += root.data;
            solve(root.left, target, to_target, to_leaf, found, ans);
            solve(root.right, target, to_target, to_leaf, found, ans);
            if(root.left == null && root.right == null)
            {
                to_leaf -= target;
                ans[0] = Math.max(ans[0], to_target - to_leaf);
            }
        }
        else
        {
            to_target += root.data;
            root = target > root.data ? root.right : root.left;
            solve(root, target, to_target, to_leaf, found, ans);
        }
    }
}