/*Complete the finction below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
//Amazon
class Solution {
    public int maxLevelSum(Node root) {
        // add code here.
        int ans = Integer.MIN_VALUE;
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            int curSum = 0;
            while(size-- > 0)
            {
                Node cur = qu.poll();
                curSum += cur.data;
                if(cur.left != null)
                    qu.offer(cur.left);
                if(cur.right != null)
                    qu.offer(cur.right);
            }
            ans = Math.max(ans, curSum);
        }
        return ans;
    }
}