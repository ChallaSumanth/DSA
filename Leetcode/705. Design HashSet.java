//Amazon 3 Microsoft 2
class MyHashSet {
    private boolean[] flag;
    public MyHashSet() {
        flag = new boolean[1000001];
    }
    
    public void add(int key) {
        flag[key] = true;
    }
    
    public void remove(int key) {
        flag[key] = false;
    }
    
    public boolean contains(int key) {
        return flag[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */