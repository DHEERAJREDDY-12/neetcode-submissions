class NumMatrix {
    int[][] mat;
    int ans=0;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        mat=matrix;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    if(i!=0){
                        mat[i][j]+=mat[i-1][j];
                    }
                }
                else{
                    if(i!=0){
                        mat[i][j]+=mat[i][j-1]+mat[i-1][j]-mat[i-1][j-1];
                    }
                    else{
                        mat[i][j]+=mat[i][j-1];
                    }
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int big=mat[row2][col2];
        int up=0;
        int left=0;
        int diag=0;
        if(row1>0){
            up=mat[row1-1][col2];
        }
        if(col1>0){
            left=mat[row2][col1-1];
        }
        if(row1>0&&col1>0){
            diag=mat[row1-1][col1-1];
        }
        return big-up-left+diag;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */