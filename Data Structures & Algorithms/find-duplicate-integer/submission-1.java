class Solution {
    public int findDuplicate(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int ind=Math.abs(arr[i]);
            if(arr[ind]<0){
                return ind;
            }
            arr[ind]*=-1;
        }
        return -1;
    }
}
