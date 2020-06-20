class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> list= new ArrayList<>();
        if(matrix == null || matrix.length == 0) return list;
        int rowUp = 0;
        int rowDown = matrix.length -1;
        int colLeft = 0;
        int colRight = matrix[0].length -1;
        while(rowUp <= rowDown && colLeft <= colRight)
        {
            for(int i = colLeft; i <= colRight; i++)
                list.add(matrix[rowUp][i]);
            
            for(int i = rowUp + 1; i <= rowDown; i++)
                list.add(matrix[i][colRight]);
            
            if(rowUp < rowDown && colLeft < colRight)
            {   
                for(int i = colRight - 1; i > colLeft; i--)
                    list.add(matrix[rowDown][i]);
                
                for(int i = rowDown; i > rowUp; i--)
                    list.add(matrix[i][colLeft]);
                
            }
            colRight--;
            rowUp++;
            rowDown--;
            colLeft++;
        }
        return list;
    }
}