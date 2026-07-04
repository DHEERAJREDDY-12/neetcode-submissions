class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        for(int num:nums){
            if(!h.add(num)){
                return true;
            }
            
        }
        return false;
    }
}