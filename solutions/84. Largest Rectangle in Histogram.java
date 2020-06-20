// divide and conquer
class Solution
{
    public int largestRectangleArea(int[] heights) 
    {
        return binary(heights, 0, heights.length -1);
    }
    
    private int binary(int[] heights, int left, int right) 
    {
        if (left > right) return 0;
        if (left == right) return heights[left];
        
        boolean increase = true, decrease = true;
        int minIndex = left;
        for (int i = left + 1; i <= right; i++) 
        {
            if (heights[i] < heights[i-1]) increase = false;
            if (heights[i] > heights[i-1]) decrease = false;
            if (heights[i] < heights[minIndex]) 
                minIndex = i;
        }
        int res = 0;
        if (decrease)
        {
            for (int i = right; i >= left; i--) 
                res = Math.max(res, heights[i] * (i - left + 1));
        } 
        else if (increase) 
        {
            for (int i = left; i <= right; i++) 
                res = Math.max(res, heights[i] * (right - i + 1));
        }
        else
        {
            int l = binary(heights, left, minIndex - 1);
            int r = binary(heights, minIndex + 1, right);
            res = Math.max(Math.max(l, r), heights[minIndex] * (right - left + 1));
        }
        return res;
    }
}