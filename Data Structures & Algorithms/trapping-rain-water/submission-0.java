class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int ans=0;
        Stack<int[]> st=new Stack<>();
        for(int r=0;r<n;r++){
            while(!st.isEmpty()&&height[r]>st.peek()[0]){
                int[] bottom=st.pop();
                if(st.isEmpty()){
                    break;
                }
                int[] left=st.peek();
                int h=Math.min(left[0],height[r])-bottom[0];
                int width=r-left[1]-1;
                ans=ans+width*h;
            }
            System.out.print(ans+" ");
            st.push(new int[]{height[r],r});
        }
        return ans;
    }
}
