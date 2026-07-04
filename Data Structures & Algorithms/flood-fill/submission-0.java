class Solution {
    int[] dr={1,-1,0,0};
    int[] dc={0,0,1,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int org=image[sr][sc];
        dfs(image,sr,sc,color,org);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int color,int org){
        int m=image.length;
        int n=image[0].length;
        if (image[sr][sc]==org){
            image[sr][sc]=color;
            for(int i=0;i<4;i++){
                int nr=sr+dr[i];
                int nc=sc+dc[i];
                if(nr>=0&&nc>=0&&nr<m&&nc<n){
                    dfs(image,nr,nc,color,org);
                }
            }
        }

    }    
}