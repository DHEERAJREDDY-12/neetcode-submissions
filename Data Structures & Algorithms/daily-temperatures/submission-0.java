class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Stack<int[]> st=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            if(st.isEmpty()||temperatures[i]<=st.peek()[0]){
                st.push(new int[]{temperatures[i],i});
            }
            else{
                while(!st.isEmpty()&&st.peek()[0]<temperatures[i]){
                    int[] arr=st.pop();
                    int ind=arr[1];
                    ans[ind]=i-ind;
                }
                st.push(new int[]{temperatures[i],i});
            }
        }
        return ans;
    }
}