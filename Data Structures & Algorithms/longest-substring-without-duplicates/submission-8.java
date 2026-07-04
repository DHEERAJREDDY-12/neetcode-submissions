class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1){
            return s.length();
        }
        HashSet<Character> set=new HashSet<>();
       
        int max=0;
        int l=0;
        int r=0;
        for(char c:s.toCharArray()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            r++;
            max=Math.max(max,r-l);
        }
        

        return max;
    }
}
