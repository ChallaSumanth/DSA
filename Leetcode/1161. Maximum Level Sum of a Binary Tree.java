//Facebook 3
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        int level = 0;
        int curLevel = 0;
        qu.offer(root);
        int sum = Integer.MIN_VALUE;
        while(!qu.isEmpty())
        {
            int size = qu.size();
            int temp = 0;
            while(size-- > 0)
            {
                TreeNode node = qu.poll();
                if(node != null)
                {
                    temp += node.val;
                }
                if(node.left != null)
                    qu.offer(node.left);
                if(node.right != null)
                    qu.offer(node.right);
            }
            curLevel++;
            if(temp > sum)
            {
                sum = temp;
                level = curLevel;
            }
        }
        return level;
    }
}