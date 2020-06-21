class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        return mergeSort(matrix, 0, m-1, 0, n-1, target);
    }
    private boolean mergeSort(int[][]matrix, int left, int right, int up, int down, int target)
    {
        if(left>right||up>down)
            return false;
        else if(target<matrix[up][left]||target>matrix[down][right])
            return false;
        
        int mid = left + (right - left)/2;
        int row = up;
        while(row <= down && matrix[row][mid] <= target)
        {
            if(matrix[row][mid]==target)
                return true;
            row++;
        }
        return mergeSort(matrix, left, mid-1, row, down, target) || mergeSort(matrix, mid+1, right, up, row-1, target);
    }
}