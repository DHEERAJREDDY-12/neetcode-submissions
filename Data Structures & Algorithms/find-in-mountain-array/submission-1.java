/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lm=1;
        int lr=mountainArr.length()-1;
        while(lm<lr){
            int mid=lm+(lr-lm)/2;
            int mid1=mid+1;
            if(mountainArr.get(mid)<mountainArr.get(mid1)){
                lm=mid+1;
            }
            else if(mountainArr.get(mid)>mountainArr.get(mid1)){
                lr=mid;
            }
        }
        int peak=lm;
        int l=0;
        int r=peak;
        boolean found=false;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==mountainArr.get(mid)){
                found=true;
                return mid;
            }
            else if(target>mountainArr.get(mid)){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(!found){
            l=peak;
            r=mountainArr.length()-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(mountainArr.get(mid)==target){
                    return mid;
                }
                else if(mountainArr.get(mid)>target){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}