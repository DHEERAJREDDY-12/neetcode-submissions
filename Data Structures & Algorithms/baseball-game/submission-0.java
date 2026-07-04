class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(String s:operations){
            if(s.charAt(0)=='D'){
                int num=st.pop();
                int num2=num*2;
                st.push(num);
                st.push(num2);
                ans+=num2;
            }
            else if(s.charAt(0)=='+'){
                int a =st.pop();
                int b=st.pop();
                int c=a+b;
                st.push(b);
                st.push(a);
                st.push(c);
                ans+=c;
            }
            else if(s.charAt(0)=='C'){
                int b=st.pop();
                ans-=b;
            }
            else{
                int num=Integer.parseInt(s);
                st.push(num);
                ans+=num;
            }
        }
        return ans;

    }
}