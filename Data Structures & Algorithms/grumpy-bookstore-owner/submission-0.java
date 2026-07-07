class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left=0;
        int satisfied=0;
        int window=0;
        int max=0;
        for(int right=0;right<customers.length;right++){
            if(grumpy[right]==1){
                window+=customers[right];
            }
            else{
                satisfied+=customers[right];
            }
            if(right-left+1>minutes){
                if(grumpy[left]==1){
                    window-=customers[left];
                }
                left++;
            }
            max=Math.max(window,max);
        }
        return satisfied+max;
    }
}