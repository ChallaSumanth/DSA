//1.bfs
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(qu.peek() != null)
        {
            TreeNode cur = qu.poll();
            if(cur.left == null && cur.right != null) return false;
            qu.offer(cur.left);
            qu.offer(cur.right);
        }
        while(!qu.isEmpty() && qu.peek() == null) qu.poll();
        return qu.isEmpty();
    }
}
//2.dfs
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return dfs(1, totalNodes, root);
    }
    private int countNodes(TreeNode root)
    {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private boolean dfs(int curCount, int totalNodes, TreeNode root)
    {
        if(root == null) return true;

        if(curCount > totalNodes) return false;

        return dfs(2 * curCount, totalNodes, root.left) &&
               dfs(2 * curCount + 1, totalNodes, root.right);
    }
}