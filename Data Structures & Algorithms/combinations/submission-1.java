class Solution {
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k,new ArrayList<>());
        return arr;
    }
    void dfs(int a,int n,int k,List<Integer> temp){
        if(temp.size()==k){
            arr.add(new ArrayList<>(temp));
            return;
        }
        if(a>n){
            return;
        }
        if(a<=n){
            temp.add(a);
        }
        dfs(a+1,n,k,temp);
        temp.remove(temp.size()-1);
        dfs(a+1,n,k,temp);
        
    }
}