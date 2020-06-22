class NumMatrix
{
    int[][] matrix;
    public NumMatrix(int[][] matrix) 
    {
        this.matrix = matrix;
        if (matrix.length != 0)
        {
            int n = matrix.length;
            int m = matrix[0].length;
            for(int i=1;i<n;i++)
                for(int j=0;j<m;j++)
                    matrix[i][j]+=matrix[i-1][j];
        }
    }
    
    public void update(int row, int col, int val) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int currValue = 0;
        if (row == 0)
            currValue = matrix[row][col];
        else
            currValue = matrix[row][col] - matrix[row-1][col];
        int diff = val - currValue;
        for(int i=row; i<n;i++) 
            matrix[i][col]+=diff;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int sum = 0;
        for(int i= col1; i<=col2;i++)
        {
            int prev = (row1 ==0)? 0 : matrix[row1-1][i];
            sum = sum + matrix[row2][i] - prev;
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */