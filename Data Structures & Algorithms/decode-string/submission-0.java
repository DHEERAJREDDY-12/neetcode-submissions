class Solution {
    public String decodeString(String s) {
        Stack<String> st=new Stack<>();
        Stack<Integer> st1=new Stack<>();
        int num=0;
        String str="";
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='['){
                
                st.push(str);
                str="";
                
                st1.push(num);
                num=0;
            }
            else if(ch==']'){
                int n=st1.pop();
                String strr=st.pop();
                String temp="";
                for(int i=0;i<n;i++){
                    temp+=str;
                }
                str=strr+temp;
            }
            else{
                str+=ch;
            }
        }
        return str;
    }
}