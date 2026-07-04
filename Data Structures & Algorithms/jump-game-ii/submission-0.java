class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int l=0;
        int r=0;
        while(r<nums.length-1){
            int f=0;
            for(int i=l;i<=r;i++){
                f=Math.max(f,i+nums[i]);
            }
            l++;
            r=Math.max(r,f);
            jumps++;
        }
        return jumps;
    }
}
