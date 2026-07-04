class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }
        int count=1;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)){
                    return count;
                }
                
                int len=word.length();
                for(int l=0;l<len;l++){
                    for(int j=0;j<26;j++){
                        char cha=(char)('a'+j);
                        String str="";
                        for(int k=0;k<word.length();k++){
                            if(k==l){
                                str+=cha;
                            }
                            else{
                                str+=word.charAt(k);
                            }
                        }
                        if(set.contains(str)){
                            q.offer(str);
                            set.remove(str);
                        }
                    }
                    
                }
            }
            count+=1;
        }
        return 0;
    }
}
