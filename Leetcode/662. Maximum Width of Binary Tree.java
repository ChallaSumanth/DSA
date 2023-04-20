//Amazon 6 Google 4 Microsoft 3 Facebook 3 Bloomberg 2
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
class Pair
{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num)
    {
        this.node = node;
        this.num = num;
    }
}
class Solution {
   public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair> qu = new LinkedList<>();
       qu.offer(new Pair(root, 0));
       int max = 0;
       while(!qu.isEmpty())
       {
           int first = 0;
           int last  = 0;
           int num = qu.peek().num;
           int size = qu.size();
           for(int i = 0; i < size; i++)
           {
              Pair p = qu.poll();
              TreeNode node = p.node;
              int cur_id = p.num - num;
              if(i == 0) first = cur_id;
              if(i == size - 1) last = cur_id;
              if(node.left != null)    qu.offer(new Pair(node.left, 2 * cur_id + 1));
              if(node.right != null)   qu.offer(new Pair(node.right, 2 * cur_id + 2));
           }
           max = Math.max(max, last - first + 1);
       }
       return max;
   }
}