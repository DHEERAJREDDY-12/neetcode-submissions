class WordDictionary {
    class Node{
        Node[] links=new Node[26];
        boolean end=false;
    }
    Node root=new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
        Node temp=root;
         for(int i = 0;
            i < word.length();
            i++) {
            int ind =word.charAt(i) - 'a';
            if(temp.links[ind]== null) {
                temp.links[ind] =new Node();
            }
            temp =
                temp.links[ind];
        }
        temp.end = true;
    }
    public boolean search(String word) {
        return dfs(word,0,root);
    }
    public boolean dfs(String word,int ind,Node node){
        if(ind==word.length()){
            return node.end;
        }
        char ch=word.charAt(ind);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(node.links[i]!=null){
                    if(dfs(word,ind+1,node.links[i])) return true;
                }
            }
            return false;
        }
        else{
            int k=ch-'a';
            if(node.links[k]==null){
                return false;
            }
            return dfs(word,ind+1,node.links[k]);
        }
        

    }
}
