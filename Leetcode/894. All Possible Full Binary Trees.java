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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n % 2 == 0) return ans;
        if(n == 1)
        {
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i = 1; i < n; i += 2)
        {
            int j = n - i - 1;
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(j);

            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
//2.Memorization
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
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n % 2 == 0) return ans;
        if(map.get(n) != null) return map.get(n);
        if(n == 1)
        {
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i = 1; i < n; i += 2)
        {
            int j = n - i - 1;
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(j);

            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
            map.put(n, ans);
        }
        return map.get(n);
    }
}