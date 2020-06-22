class Vector2D
{
    private int[][] v;
    private int curRow;
    private int curCol;

    public Vector2D(int[][] v) 
    {
        this.v = v;
        while (curRow < v.length && v[curRow].length == 0) 
            curRow++;
    }
    
    public int next()
    {
        int[] row = v[curRow];
        int val = row[curCol++];
        if (curCol == row.length) 
        {
            curRow++; curCol = 0;
            while (curRow < v.length && v[curRow].length == 0) 
                curRow++;
        }
        return val;
    }
    
    public boolean hasNext() 
    {
        return curRow < v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
