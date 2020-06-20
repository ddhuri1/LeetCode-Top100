class Solution 
{
    public int maxArea(int[] height) 
    {
        if(height.length <= 1) return 0;
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        int ptr = 0;
        int area = 0;
        while(i < height.length && j > 0)
        {
            int min = Math.min(height[i],height[j]);
            area = min * (j - i);
            if(max < area)
            {
                max = area;
            }
            if(height[i] > height[j])
            {
                j--;
            }
            else
            {
                i++;
            }
            
        }
        return max;
    }
}