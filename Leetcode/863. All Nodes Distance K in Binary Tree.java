/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track)
    {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty())
        {
            TreeNode cur = qu.poll();
            if(cur.left != null)
            {
                qu.offer(cur.left);
                parent_track.put(cur.left, cur);
            }
            if(cur.right != null)
            {
                qu.offer(cur.right);
                parent_track.put(cur.right, cur);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(target);
        int cur_level = 0;
        while(!qu.isEmpty())
        {
            if(cur_level == k) break;
            cur_level++;
            int size = qu.size();
            while(size-- > 0)
            {
                TreeNode cur = qu.poll();
                if(cur.left != null && visited.get(cur.left) == null)
                {
                    visited.put(cur.left, true);
                    qu.offer(cur.left);
                }
                if(cur.right != null && visited.get(cur.right) == null)
                {
                    visited.put(cur.right, true);
                    qu.offer(cur.right);
                }
                if(parent_track.get(cur) != null && visited.get(parent_track.get(cur)) == null)
                {
                    visited.put(parent_track.get(cur), true);
                    qu.offer(parent_track.get(cur));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!qu.isEmpty())
            ans.add(qu.poll().val);
        return ans;
    }
}