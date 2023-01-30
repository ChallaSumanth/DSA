/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        int [] count = new int[1];
        if(dfs(root,count) == -1)
            count[0]++;
        return count[0];
    }
    private int dfs(TreeNode root,int [] count)
    {
        //-1 -> camera needed (node asks it's parent to cover it)
        // 1 -> camera not needed (node says its covered)
        // 0 -> node has been covered (returns status to parent that it has a camera and is already covered)
        if(root == null)
            return 1;
        int left = dfs(root.left,count);
        int right = dfs(root.right,count);
        if(left == -1 || right == -1)
        {
            count[0]++;
            return 0;   //return 0 -> this node is now covered
        }
        if(left == 0 || right == 0) // check if both the nodes are covered return 1
            return 1;
        return -1;  //else ask the parent to handle since its not covered
    }
}