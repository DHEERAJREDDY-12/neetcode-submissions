class Solution {
    public int maxProfit(int[] prices) {
        int low=prices[0];
        int high=prices[0];
        int diff=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-high<0){
                high=prices[i];
            }
            else if(prices[i]-high>diff){
                diff=prices[i]-high;
            }
            System.out.println(diff);

        }
        return diff;
    }
}
