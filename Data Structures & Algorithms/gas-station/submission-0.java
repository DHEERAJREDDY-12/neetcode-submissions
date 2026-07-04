class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int st=0;
        int curtank=0;
        for(int i=0;i<gas.length;i++){
            int dif=gas[i]-cost[i];
            sum+=dif;
            curtank+=dif;
            if(curtank<0){
                st=i+1;
                curtank=0;
            }
           
        }
        if(sum<0){
            return -1;
        }
        return st;
    }
}
