class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][n-1]=='O') dfs(board,i,n-1);
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[m-1][i]=='O') dfs(board,m-1,i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }
    void dfs(char[][] board,int r,int c){
        
        int m=board.length;
        int n=board[0].length;
        board[r][c]='#';
        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>0&&nc>0&&nr<m-1&&nc<n-1&&board[nr][nc]=='O'){
                
                dfs(board,nr,nc);
            }
        }
    }
}
