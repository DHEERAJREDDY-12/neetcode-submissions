class Solution {
    public boolean isPalindrome(String s) {
        int j=s.length()-1;
        int i=0;
        while(i<j){

            char ss;
            char cc;

            if((s.charAt(i)>='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                ss=Character.toLowerCase(s.charAt(i));
            }
            else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                ss=s.charAt(i);
            }
            else{
                i++;
                continue;
            }

            if((s.charAt(j)>='A'&&s.charAt(j)<='Z')||(s.charAt(j)>='a'&&s.charAt(j)<='z')){
                cc=Character.toLowerCase(s.charAt(j));
            }
            else if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
                cc=s.charAt(j);
            }
            else{
                j--;
                continue;
            }

            if(ss!=cc){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}