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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean reverse = true;
        while(!qu.isEmpty())
        {
            int size = qu.size();
            LinkedList<Integer> list = new LinkedList<>();
            while(size-- > 0)
            {
                TreeNode cur = qu.poll();
                if(reverse)
                    list.add(cur.val);
                else
                    list.addFirst(cur.val);
                if(cur.left != null)
                    qu.offer(cur.left);
                if(cur.right != null)
                    qu.offer(cur.right);
            }
            reverse = !reverse;
            ans.add(list);
        }
        return ans;
    }
}