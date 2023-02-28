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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        helper(root,map,ans);
        return ans;
    }
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> ans)
    {
        if(root == null) return "NULL";

        String left = helper(root.left, map, ans);
        String right = helper(root.right, map, ans);

        String cur = root.val + "#" + left + "#" + right;
        if(map.getOrDefault(cur,0) == 1)
            ans.add(root);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }
}