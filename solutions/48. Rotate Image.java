class Solution 
{
    //swap and transpose
    
    public void rotate(int[][] matrix) 
    {
        //swap
        for(int i = 0; i < matrix.length / 2; i++)
        {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
        
        //transpose
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = i; j < matrix.length; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    /*
    //pointer swap
    public void rotate(int[][] matrix) 
    {
        int len = matrix.length;
        //swap
        for(int i=0;i<len/2;i++)
        {
            for(int j =i;j<len-i-1;j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }
    */
}