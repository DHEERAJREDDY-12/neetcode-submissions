class Solution {
    public boolean validPalindrome(String s) {
        int j=s.length()-1;

        for(int i=0;i<j;i++){

            if(s.charAt(i)!=s.charAt(j)){

                boolean left=true;
                int l=i+1;
                int r=j;

                while(l<r){
                    if(s.charAt(l)!=s.charAt(r)){
                        left=false;
                        break;
                    }
                    l++;
                    r--;
                }

                boolean right=true;
                l=i;
                r=j-1;

                while(l<r){
                    if(s.charAt(l)!=s.charAt(r)){
                        right=false;
                        break;
                    }
                    l++;
                    r--;
                }

                return left||right;
            }

            j--;
        }

        return true;
    }
}