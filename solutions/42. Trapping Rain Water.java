class Solution 
{
    public int trap(int[] height) 
    {
        int left = 0, right = 0;
        int start = 0, end = height.length - 1;
        int ans = 0;
        while(start < end )
        {
            if(height[start] < height[end])
            {
                if(height[start] >= left)
                {
                    left = height[start];
                    start ++;
                }
                else
                {
                    ans += left - height[start];
                    start++;
                }
            }
            else
            {
                if(height[end] >= right)
                {
                    right = height[end];
                    end --;
                }
                else
                {
                    ans += right - height[end];
                    end--;
                }
            }
        }
        return ans;
    }
}