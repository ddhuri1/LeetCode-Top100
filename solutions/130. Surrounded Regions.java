class Solution
{
  public void solve(char[][] board) 
  {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        int m = board.length, n = board[0].length;
        for(int j = 0; j<n; j++)
        {
            if(board[0][j] == 'O')
                bfs(board, 0, j);
            if(board[m-1][j] == 'O')
                bfs(board, m-1, j);
        }
        for(int i = 0; i<m; i++)
        {
            if(board[i][0] == 'O')
                bfs(board, i, 0);
            if(board[i][n-1] == 'O')
                bfs(board, i, n-1);
        }
        convert(board, 'O', 'X');
        convert(board, 'I', 'O');
    }
    
    public void bfs(char[][] board, int i, int j)
    {
        if(i < 0 || i>= board.length || j < 0 || j>=board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'I';
        bfs(board, i-1, j);
        bfs(board, i+1, j);
        bfs(board, i, j-1);
        bfs(board, i, j+1);
    }
    
    public void convert(char[][] board, char a, char b)
    {
        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++)
                if(board[i][j] == a)
                    board[i][j] = b;
    }
}