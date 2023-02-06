class Pair
{
    int level;
    Node node;
    Pair(int level,Node node)
    {
        this.level = level;
        this.node = node;
    }
}
class Solution
{
    long verticallyDownBST(Node root,int target)
    {
        while(root != null && target != root.data )
        {
            if(target < root.data)
                root = root.left;
            else if(target > root.data)
                root = root.right;
            if(root == null || target == root.data)
                break;
        }
        if(root == null) return -1;
        if(root != null && root.data != target)
                return -1;
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(0,root));
        long sum = 0;
        while(!qu.isEmpty())
        {
            int level = qu.peek().level;
            Node node = qu.peek().node;
            qu.poll();
            if(level == 0)
            {
                sum += node.data;
            }
            if(node.left != null)
            qu.offer(new Pair(level - 1,node.left));
            if(node.right != null)
            qu.offer(new Pair(level + 1,node.right));
        }
        return sum - target;
    }
}