//https://practice.geeksforgeeks.org/problems/95423710beef46bd66f8dbb48c510b2c320dab05/1
//Amazon,Microsoft,Google,Flipkart.....

class Solution {
    public void connect(Node root) {
        // code here
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty())
        {
            Node nextRightPointer = null;
            int size = qu.size();
            while(size-- > 0)
            {
                Node cur = qu.poll();
                cur.nextRight = nextRightPointer;
                nextRightPointer = cur;
                if(cur.right != null)
                    qu.offer(cur.right);
                if(cur.left != null)
                    qu.offer(cur.left);
            }
        }
        
    }
}