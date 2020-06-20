class Solution 
{
    public boolean exist(char[][] board, String word) 
    {
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == chs[0] && dfs(board, i, j, chs, 0)) 
                    return true;
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chs, int idx)
    {
        if (idx == chs.length) 
            return true;
        if (i < 0 || i == board.length || j < 0 || j == board[i].length || board[i][j] != chs[idx]) 
            return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean canFound =  dfs(board, i + 1, j, chs, idx + 1) ||
                            dfs(board, i - 1, j, chs, idx + 1) ||
                            dfs(board, i, j - 1, chs, idx + 1) ||
                            dfs(board, i, j + 1, chs, idx + 1);

        board[i][j] = c;
        return canFound;
    }
}