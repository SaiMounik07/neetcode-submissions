class MinStack {
    Stack<Integer> st;
    Stack<Integer> mSt;

    public MinStack() {
        st = new Stack<>();
        mSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mSt.isEmpty() || val <= mSt.peek()) 
            mSt.push(val);
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int t = st.pop();
        if(t == mSt.peek())
            mSt.pop();
    }
    
    public int top() {
       return st.peek();
    }
    
    public int getMin() {
        return mSt.peek();
    }
}
