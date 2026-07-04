class Solution {
    public boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
        Stack<Character> st=new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }
            
            else{
                if(st.isEmpty()){
                    return false;
                }
                char c=st.pop();
                if(ch==')'){
                    if(c!='(') return false;
                }
                if(ch==']'){
                    if(c!='[') return false;
                }
                if(ch=='}'){
                    if(c!='{') return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        
        return true;
    }
}
