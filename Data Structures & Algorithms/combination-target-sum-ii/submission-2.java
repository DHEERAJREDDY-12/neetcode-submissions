class Solution {
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,0,candidates,target,new ArrayList<>());
        return arr;
    }
    void dfs(int sum,int ind,int[] candidates,int target,List<Integer> temp){
        if(sum==target){
            arr.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target||ind>=candidates.length){
            return;
        }
        temp.add(candidates[ind]);
        dfs(sum+candidates[ind],ind+1,candidates,target,temp);
        temp.remove(temp.size()-1);
        while(ind+1<candidates.length && candidates[ind]==candidates[ind+1]){
            ind++;
        }
        dfs(sum,ind+1,candidates,target,temp);
    }
}
