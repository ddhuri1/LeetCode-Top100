class Solution 
{
    public int rob(int[] nums)
    {
        int numslength = nums.length;
        if(numslength == 0) return 0;
        if(numslength == 1) return nums[0];
        if(numslength == 2) return Math.max(nums[0],nums[1]);
        
        int[] result = new int[numslength];
        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]);
        int max = result[1];
        for(int i=2; i<numslength; i++) 
        {
            result[i] = Math.max(nums[i-1], nums[i]+result[i-2]);
            max = Math.max(max, result[i]);
            result[i] = max;
        }
        return max;
    }
}