class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str="";
        int max=Math.min(word1.length(),word2.length());
        for(int i=0;i<max;i++){
            str+=word1.charAt(i);
            str+=word2.charAt(i);
        }
        if(word1.length()==max){
            str+=word2.substring(max);
        }
        else{
            str+=word1.substring(max);
        }
        return str;
    }
}