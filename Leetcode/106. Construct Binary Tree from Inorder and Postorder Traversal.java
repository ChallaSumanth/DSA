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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int [] postorder, int poStart, int poEnd, Map<Integer,Integer> map)
    {
        if(inStart > inEnd || poStart > poEnd) return null;

        TreeNode root = new TreeNode(postorder[poEnd]);
        int inRoot = map.get(root.val);
        int leftNums = inRoot - inStart;

        root.left = buildTreeHelper(inorder, inStart, inRoot - 1, postorder, poStart, poStart + leftNums - 1, map);
        root.right = buildTreeHelper(inorder, inRoot + 1, inEnd, postorder, poStart + leftNums, poEnd - 1, map);
        return root;
    }
}