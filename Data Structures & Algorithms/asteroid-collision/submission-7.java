class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int num:asteroids){
            int th=1;
            while(!st.isEmpty()&&st.peek()>0&&num<0){
                if(st.peek()<Math.abs(num)){
                    st.pop();
                }
                else if(st.peek()==Math.abs(num)){
                    st.pop();
                    th=0;
                    break;
                }
                else{
                    th=0;
                    break;
                }
            }
            if(th==1){
                st.push(num);
            }  
        }
        int[] arr=new int[st.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=st.get(i);
        }
        return arr;
    }
}