class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] sub = new boolean[9];
        for(int i = 0;i < 9;i++)
        {
            Arrays.fill(row, false);
            Arrays.fill(col, false);
            for(int j = 0;j< 9;j++)
            {
                if(board[i][j] != '.')
                {
                    if(row[board[i][j] - '1']) 
                        return false;
                    else 
                        row[board[i][j] - '1'] = true;
                }
                if(board[j][i] != '.')
                {
                    if(col[board[j][i] - '1']) 
                        return false;
                    else 
                        col[board[j][i] - '1'] = true;
                }
            }
        }
        
        for (int i = 0; i < 3; i++) 
        { 
            for (int j = 0; j < 3; j++) 
            { 
                Arrays.fill(sub, false);
                for (int x = i * 3; x < i * 3 + 3; x++) 
                { 
                    for (int y = j * 3; y < j * 3 + 3; y++) 
                    { 
                        if (board[x][y] != '.')
                        {
                            if(sub[board[x][y] - '1']) 
                                return false;  
                            else
                                sub[board[x][y] - '1'] = true;
                        }
                    }
                }
           }
        }
        return true;
    }
}