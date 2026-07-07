class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        Deque<Integer> dq=new LinkedList<>();
        int idx=0;
        for(int r=0;r<nums.length;r++){
            while(!dq.isEmpty()&&dq.peekFirst()<=r-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[r]){
                dq.pollLast();
            }
            dq.offerLast(r);
            if(r>=k-1){
                ans[idx++]=nums[dq.peekFirst()];
            }
        }
        return ans;

    }
}
