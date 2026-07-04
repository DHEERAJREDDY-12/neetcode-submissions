class Solution {
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        dfs(0,used,nums,new ArrayList<>());
        return arr;
    }
    void dfs(int ind,boolean[] used,int[] nums,List<Integer> temp){
        if(temp.size()==nums.length){
            arr.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                if(i==0||nums[i]!=nums[i-1]||used[i-1]){
                    used[i]=true;
                    temp.add(nums[i]);
                    dfs(i,used,nums,temp);
                    temp.remove(temp.size()-1);
                    used[i]=false;
                }
            }
        }

    }
}