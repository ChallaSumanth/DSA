//Amazon 3
class MyStack {

    private Queue<Integer> qu = null;
    public MyStack() {
        qu = new LinkedList<>();
    }
    
    public void push(int x) {
        qu.offer(x);
        for(int i = 0; i < qu.size() - 1; i++)
            qu.offer(qu.poll());
    }
    
    public int pop() {
        return qu.poll();
    }
    
    public int top() {
        return qu.peek();
    }
    
    public boolean empty() {
        return qu.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */