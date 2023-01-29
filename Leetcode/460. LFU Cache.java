class LFUCache {
    Map<Integer,DLLNode> cache;
    Map<Integer,DoublyLinkedList> freqMap;
    int capacity;
    int curSize;
    int minFreq;
    LFUCache(int _capacity) {
       this.capacity = _capacity;
       this.cache = new HashMap<>();
       this.freqMap = new HashMap<>();
       this.minFreq = 0;
       this.curSize = 0;
   }
   
   public int get(int key) {
       if(cache.containsKey(key))
       {
           DLLNode curNode = cache.get(key);
           updateNode(curNode);
           return curNode.val;
       }
       return -1;
   }
   public void updateNode(DLLNode curNode)
   {
       int curfreq = curNode.frequency;
       DoublyLinkedList freqList = freqMap.get(curfreq);
       freqList.deleteNode(curNode);
       if(minFreq == curfreq && freqList.listSize == 0)
           minFreq++;
       curNode.frequency++;
       DoublyLinkedList newList = freqMap.getOrDefault(curNode.frequency,new DoublyLinkedList());
       newList.addNode(curNode);
       freqMap.put(curNode.frequency,newList);
   }
   
   public void put(int key, int value) {
       if(capacity == 0) return;
       if(cache.containsKey(key))
       {
           DLLNode curNode = cache.get(key);
           curNode.val = value;
           updateNode(curNode);
       }
       else
       {
           curSize++;
           if(curSize > capacity)
           {
               DoublyLinkedList minFreqList = freqMap.get(minFreq);
               cache.remove(minFreqList.tail.prev.key);
               minFreqList.deleteNode(minFreqList.tail.prev);
               curSize--;
           }
               minFreq = 1;
               DLLNode newNode = new DLLNode(key,value);
               cache.put(key,newNode);
               DoublyLinkedList newList = freqMap.getOrDefault(1,new DoublyLinkedList());
               newList.addNode(newNode);
               freqMap.put(1,newList);
       }
   }
   class DLLNode
   {
       DLLNode next;
       DLLNode prev;
       int frequency;
       int key,val;
       DLLNode(int key,int val)
       {
           this.key = key;
           this.val = val;
           this.frequency = 1;
       }
       
   }
   class DoublyLinkedList
   {
       DLLNode head;
       DLLNode tail;
       int listSize;
       DoublyLinkedList()
       {
           this.head = new DLLNode(0,0);
           this.tail = new DLLNode(0,0);
           head.next = tail;
           tail.prev = head;
           this.listSize = 0;
       }
       public void addNode(DLLNode newNode)
       {
           DLLNode nextNode = head.next;
           head.next = newNode;
           newNode.prev = head;
           newNode.next = nextNode;
           nextNode.prev = newNode;
           this.listSize++;
       }
       public void deleteNode(DLLNode curNode)
       {
           DLLNode nextNode = curNode.next;
           DLLNode prevNode = curNode.prev;
           prevNode.next = nextNode;
           nextNode.prev = prevNode;
           this.listSize--;
       }
   }
}

/**
* Your LFUCache object will be instantiated and called as such:
* LFUCache obj = new LFUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/