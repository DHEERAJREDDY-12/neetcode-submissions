class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        int[] arr=new int[2];
        int ind=0;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                arr[0]=l+1;
                arr[1]=r+1;
                return arr;
            }
            else if(numbers[l]+numbers[r]>target){
                r--;
            }
            else{
                l++;
            }
        }
        return arr;
    }
}
