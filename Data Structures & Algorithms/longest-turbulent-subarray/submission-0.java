class Solution {

    public int maxTurbulenceSize(int[] arr) {

        if(arr.length==1){
            return 1;
        }

        int max=1;

        int summax=1;
        int summin=1;

        for(int i=0;i<arr.length;i++){

            if(i==arr.length-1){
                max=Math.max(max,Math.max(summax,summin));
                break;
            }

            // pattern: > < > <
            if(i%2==0){

                if(arr[i]>arr[i+1]){
                    summax++;
                }
                else{
                    summax=1;
                }

                if(arr[i]<arr[i+1]){
                    summin++;
                }
                else{
                    summin=1;
                }
            }

            // pattern: < > < >
            else{

                if(arr[i]<arr[i+1]){
                    summax++;
                }
                else{
                    summax=1;
                }

                if(arr[i]>arr[i+1]){
                    summin++;
                }
                else{
                    summin=1;
                }
            }

            if(arr[i]==arr[i+1]){
                summax=1;
                summin=1;
            }

            max=Math.max(max,Math.max(summax,summin));
        }

        return max;
    }
}