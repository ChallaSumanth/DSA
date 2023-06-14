//Google 3
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
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        int[] minDiff = new int[1];
        minDiff[0] = Integer.MAX_VALUE;
        findDiff(root, minDiff);
        return minDiff[0];
    }
    private void findDiff(TreeNode root, int[] minDiff)
    {
        if(root != null)
        {
            findDiff(root.left, minDiff);
            if(prev != null)
                minDiff[0] = Math.min(minDiff[0], Math.abs(root.val - prev.val));
             prev = root;
            findDiff(root.right, minDiff);
        }

    }
}