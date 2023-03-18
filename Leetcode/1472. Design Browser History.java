//imp
class DoublyLinkedList
{
    String url;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    DoublyLinkedList(String url)
    {
        this.url = url;
    }

}
class BrowserHistory {

    private DoublyLinkedList head;
    private DoublyLinkedList cur;
    public BrowserHistory(String homepage) {
        head = new DoublyLinkedList(homepage);
        cur = head;
    }
    
    public void visit(String url) {
        DoublyLinkedList nextCurr = new DoublyLinkedList(url);
        cur.next = nextCurr;
        nextCurr.prev = cur;
        cur = nextCurr;
    }
    
    public String back(int steps) {
        while(cur.prev != null && steps > 0)
        {
            cur = cur.prev;
            steps--;
        }
        return cur.url;
    }
    
    public String forward(int steps) {
        while(cur.next != null && steps > 0)
        {
            cur = cur.next;
            steps--;
        }
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */