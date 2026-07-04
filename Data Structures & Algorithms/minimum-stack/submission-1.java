class MinStack {
    Stack<Integer> st;
    Stack<Integer> mst;        
    public MinStack() {
        st=new Stack<>();
        mst=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mst.isEmpty()||mst.peek()>=val){
            mst.push(val);
        }
    }
    
    public void pop() {
        int num=st.pop();
        if(num==mst.peek()){
            mst.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mst.peek();
    }
}
