//https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1
//paytm,amazon,microsoft.....
class Solution {
    public Node correctBST(Node root) {
        // code here.
        List<Integer> inodr = new ArrayList<>();
        Node cur = root;
        inOrder(cur,inodr);
        int size = inodr.size();
        int a = 0;
        int b = 0;
        for(int i = 0; i < size - 1; i++)
        {
            if(inodr.get(i) > inodr.get(i+1))
            {
                a = inodr.get(i);
                break;
            }
        }
        for(int i = size - 1; i > 0; i--)
        {
            if(inodr.get(i) < inodr.get(i - 1))
            {
                b = inodr.get(i);
                break;
            }
        }
        swap(root,a,b);
        return root;
    }
    private void swap(Node root,int a, int b)
    {
        if(root == null) return;
        
        if(root.data == a)
            root.data = b;
        else if(root.data == b)
            root.data = a;
        swap(root.left,a,b);
        swap(root.right,a,b);
            
    }
    private void inOrder(Node root,List<Integer> inodr)
    {
        if(root == null)
            return;
        inOrder(root.left,inodr);
        inodr.add(root.data);
        inOrder(root.right,inodr);
    }
}