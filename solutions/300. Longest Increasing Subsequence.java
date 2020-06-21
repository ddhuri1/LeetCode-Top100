class Solution
{
    public int lengthOfLIS(int[] nums)
    {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for(int num : nums) 
        {
            if(dp[len - 1] < num)
            {
                dp[len] = num;
                len ++;
            } 
            else 
            {
                int pos = findPos(0, len - 1, num, dp);
                dp[pos] = num;
            }
        }
        return len;
    }
    
    private int findPos(int i, int j, int num, int[] dp)
    {
         while(i <= j) 
         {
             int mid = i +  (j - i) / 2;
             if(dp[mid] == num) 
                return mid;
             else if(dp[mid] < num) 
                i = mid + 1;
             else 
                j = mid - 1;
            }
        return i;
    }
}