class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        int prev1=cost[1];
        int prev2=cost[0];
        for(int i=2;i<cost.length;i++){
            
            int curr=Math.min(prev1+cost[i],prev2+cost[i]);
            prev2=prev1;
            prev1=curr;
        }
        
        return Math.min(prev1,prev2);

    }
}
