class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        boolean[] used=new boolean[nums.length];
        dfs(nums,used,new ArrayList<>());
        return res;
    }
    void dfs(int[] nums,boolean[] used,List<Integer> temp){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                temp.add(nums[i]);
                dfs(nums,used,temp);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
        }
    }
}