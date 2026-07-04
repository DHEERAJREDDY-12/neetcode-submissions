class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // First and last column
        for (int r = 0; r < rows; r++) {

            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }

            if (board[r][cols - 1] == 'O') {
                dfs(r, cols - 1, board);
            }
        }

        // First and last row
        for (int c = 0; c < cols; c++) {

            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }

            if (board[rows - 1][c] == 'O') {
                dfs(rows - 1, c, board);
            }
        }

        // Convert cells
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 || c < 0 ||
            r >= rows || c >= cols ||
            board[r][c] != 'O') {

            return;
        }

        // Mark safe
        board[r][c] = '#';

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            dfs(nr, nc, board);
        }
    }
}