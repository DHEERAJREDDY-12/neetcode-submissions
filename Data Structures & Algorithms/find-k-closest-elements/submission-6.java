class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        int maxdiff=Integer.MIN_VALUE;
        int n=arr.length;
        int count=0;
        int l=0;
        for(int r=0;r<n;r++){
            if(count<k){
                ans.add(arr[r]);
                maxdiff=Math.max(maxdiff,Math.abs(x-arr[r]));
                count++;
            }
            else{
                if(Math.abs(arr[r]-x)<maxdiff){
                    ans.remove(0);
                    ans.add(arr[r]);
                    l=l+1;
                    maxdiff=Math.abs(x-arr[l]);
                }
            }
        }
        return ans;
    }
}