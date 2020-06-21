class Solution 
{
    public int longestIncreasingPath(int[][] matrix) 
    {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] map = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                int path = dfs(i, j, matrix, map);
                max = Math.max(path, max);
            }
        }
        return max;
    }
    
    public int dfs(int i, int j, int[][] matrix, int[][] map)
    {
        if(map[i][j] != 0) return map[i][j];
        int cal1 = 0;
        int cal2 = 0;
        int cal3 = 0;
        int cal4 = 0;
        if(i > 0 && matrix[i][j] < matrix[i-1][j]) 
            cal1 = dfs(i - 1, j, matrix, map);
        if(j > 0 && matrix[i][j] < matrix[i][j-1]) 
            cal2 = dfs(i, j - 1, matrix, map);
        if(i < matrix.length -1 && matrix[i][j] < matrix[i+1][j]) 
            cal3 = dfs(i + 1, j, matrix, map);
        if(j < matrix[0].length -1 && matrix[i][j] < matrix[i][j+1]) 
            cal4 = dfs(i, j + 1, matrix, map);
        int max1 = Math.max(cal1, cal2);
        int max2 = Math.max(cal3, cal4);
        int max = Math.max(max1, max2);
        map[i][j] = max + 1;
        return max + 1;
    }
}