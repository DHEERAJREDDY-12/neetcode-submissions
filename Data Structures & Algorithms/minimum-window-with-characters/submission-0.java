class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> win=new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int form=0;
        int min=Integer.MAX_VALUE;
        int l=0;
        int start=0;
        for(int r=0;r<s.length();r++){
            win.put(s.charAt(r),win.getOrDefault(s.charAt(r),0)+1);
            if(need.containsKey(s.charAt(r))){
                if(win.get(s.charAt(r))==need.get(s.charAt(r))){
                    form+=1;
                }
            }
            while(form==need.size()){
                if(r-l+1<min){
                    min=r-l+1;
                    start=l;
                }
                if(win.containsKey(s.charAt(l))){
                    if(win.get(s.charAt(l))>1) win.put(s.charAt(l),win.get(s.charAt(l))-1);
                    else win.remove(s.charAt(l));
                    if(need.containsKey(s.charAt(l)) && 
                       win.getOrDefault(s.charAt(l),0)<need.get(s.charAt(l))){
                        form--;
                    }
                }
                l++;
            }
        }

        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+min);
    }
}