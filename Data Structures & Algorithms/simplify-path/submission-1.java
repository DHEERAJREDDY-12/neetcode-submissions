class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] sts=path.split("/");
        for(String s:sts){
            if(s.equals(".")||s.equals("")){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
                
            }
            else{
                st.push(s);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String stss:st){
            sb.append("/").append(stss);
        }
        String sbb=sb.toString();
        return sbb.length()==0? "/":sbb;


    }
}