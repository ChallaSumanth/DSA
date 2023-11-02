//Google Facebook Amazon
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
    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        postOrder(root, res);
        return res[0];
    }
    private int[] postOrder(TreeNode root, int[] res)
    {
        if(root == null)
            return new int[]{0, 0};
        int[] left = postOrder(root.left, res);
        int[] right = postOrder(root.right, res);
        int curValue = left[0] + right[0] + root.val;
        int curCount = left[1] + right[1] + 1;
        if(curValue / curCount == root.val)
            res[0]++;
        return new int[]{curValue, curCount};
    }
}