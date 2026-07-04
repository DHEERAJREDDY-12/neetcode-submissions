class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s:tokens){
            if(s.charAt(0)=='+'){
                int a=st.pop();
                int b=st.pop();
                int c=a+b;
                st.push(c);
            }
            else if(s.equals("-")){
                int a=st.pop();
                int b=st.pop();
                int c=b-a;
                st.push(c);
            }
            else if(s.charAt(0)=='*'){
                int a=st.pop();
                int b=st.pop();
                int c=a*b;
                st.push(c);
            }
            else if(s.charAt(0)=='/'){
                int a=st.pop();
                int b=st.pop();
                int c=b/a;
                st.push(c);
            }
            else{
                int num=Integer.parseInt(s);
                st.push(num);
            }
            
        }
        
        return st.peek();
    }
}
