//Amazon 117 Facebook 60 Microsoft 52 Apple 20 Bloomberg 19 Oracle 13 Salesforce 10 Google 9 Intuit 8
//Twilio 7 Goldman Sachs 6 tiktok 6 LinkedIn 5 ByteDance 5 Adobe 4 Walmart Global Tech 4 Yahoo 3
//Snapchat 3 Nvidia 3 VMware 2 Uber 2 Paypal 2 GoDaddy 2 Morgan Stanley 2 Docusign 2 Shopee 2
class DLLNode
{
    int key;
    int value;
    DLLNode prev;
    DLLNode next;
    DLLNode(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    private int capacity;
    private Map<Integer, DLLNode> map = null;
    DLLNode head = null;
    DLLNode tail = null;
    public LRUCache(int _capacity) {
        capacity = _capacity;
        map = new HashMap<>();
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            DLLNode cur = map.get(key);
            delete(cur);
            insert(cur);
            return cur.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            delete(map.get(key));
        if(capacity == map.size())
            delete(tail.prev);
        insert(new DLLNode(key, value));
    }
    private void insert(DLLNode Node)
    {
        map.put(Node.key, Node);
        DLLNode headNext = head.next;
        head.next = Node;
        Node.prev = head;
        Node.next = headNext;
        headNext.prev = Node;
    }
    private void delete(DLLNode Node)
    {
        map.remove(Node.key);
        Node.prev.next = Node.next;
        Node.next.prev = Node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
