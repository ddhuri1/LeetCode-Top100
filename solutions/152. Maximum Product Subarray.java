class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int maxe = nums[0];
        int mine = nums[0];
        int max = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            int temp = maxe;
            maxe = Math.max(nums[i] , Math.max(nums[i] * maxe, mine * nums[i]));
            mine = Math.min(nums[i] , Math.min(nums[i]*temp , mine * nums[i]));
            max = Math.max(max , maxe);
        }
        return max;
    }
}