class Solution 
{
    public void gameOfLife(int[][] board) 
    {	
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int live = 0;
				live = cal(board,i - 1, j - 1) + cal(board,i - 1, j) + cal(board,i - 1, j + 1) + cal(board,i, j - 1) +                                  cal(board,i, j + 1) + cal(board,i + 1, j - 1) + cal(board,i + 1, j) + cal(board,i + 1, j + 1);
				if(board[i][j] == 1){
					 if(live < 2)
                        board[i][j] = -1  ; 
					 else if(live == 2 || live == 3)
                        board[i][j] = 1 ;
					 else if(live > 3)
                        board[i][j] = -1 ;
				}
                else{
					if(live == 3)
                        board[i][j] = -2;
				}
			}
		}
		for(int i=0; i<board.length; i++){	  
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == -1) board[i][j] = 0;
                if(board[i][j] == -2) board[i][j] = 1;
            }
        }
    }
    private int cal(int[][] board, int i, int j)  {
		if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
            if(Math.abs(board[i][j]) == 0 || Math.abs(board[i][j]) == 2) return 0;
            else return 1;
        }
		return 0;
	}
}