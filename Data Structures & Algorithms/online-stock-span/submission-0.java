class StockSpanner {
    Stack<int[]> st;
    int ind=0;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        
        if(st.isEmpty()||price<st.peek()[0]){
            st.push(new int[]{price,ind++,1});
            return 1;
        }
        else{
            int ans=1;
            while(!st.isEmpty()&&price>=st.peek()[0]){
                int[] arr=st.pop();
                ans+=arr[2];
            }
            st.push(new int[]{price,ind,ans});
            return ans;
        }
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */