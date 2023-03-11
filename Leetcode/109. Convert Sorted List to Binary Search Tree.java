class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        ListNode cur = head;
        while(cur != null)
        {
            temp.add(cur.val); cur = cur.next;
        }
        return convertToBST(temp,0,temp.size()-1);
    }
    private TreeNode convertToBST(List<Integer> temp,int start, int end)
    {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(temp.get(mid));
        root.left = convertToBST(temp, start, mid - 1);
        root.right = convertToBST(temp, mid + 1, end);

        return root;
    }
}
//2.optimal
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}