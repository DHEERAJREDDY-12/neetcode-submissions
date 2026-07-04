class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank=new int[26];
        for(int i=0;i<26;i++){
            int ch=order.charAt(i)-'a';
            rank[ch]=i;
        }
        for(int i=0;i<words.length-1;i++){
            int min=Math.min(words[i].length(),words[i+1].length());
            boolean same =true;
            for(int j=0;j<min;j++){
                if(rank[words[i].charAt(j)-'a']>rank[words[i+1].charAt(j)-'a']){
                    return false;
                }
                if(rank[words[i].charAt(j)-'a']<rank[words[i+1].charAt(j)-'a']){
                    same=false;
                    break;

                }
            }
            if(same&&words[i].length()>words[i+1].length()){
                return false;
            }
        }
        return true;

    }
}