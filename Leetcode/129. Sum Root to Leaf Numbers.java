
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int sum)
    {
        if(root == null) return 0;

        if(root.left == null && root.right == null)
            return sum * 10 + root.val;
        return dfs(root.left, sum * 10 + root.val) +
                dfs(root.right, sum * 10 + root.val);
    }
}

//2.iterative
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> path = new Stack<>();
        nodeStack.push(root);
        path.push(root.val+"");
        int sum = 0;
        while(!nodeStack.isEmpty())
        {
            TreeNode curNode = nodeStack.pop();
            String curPath = path.pop();

            if(curNode.left != null)
            {
                nodeStack.push(curNode.left);
                path.push(curPath + curNode.left.val +"");
            }
            if(curNode.right != null)
            {
                nodeStack.push(curNode.right);
                path.push(curPath + curNode.right.val +"");
            }
            if(curNode.left == null && curNode.right == null)
            sum += Integer.parseInt(curPath);
        }
        return sum;
    }
}