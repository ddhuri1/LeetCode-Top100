class Solution 
{
    Random r = new Random();
    int[] nums;
    public Solution(int[] nums)
    {
        this.nums = nums;  
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset()
    {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle()
    {
        int len = nums.length;
        int[] sh = new int[len];
        for(int i=0;i<sh.length;i++)
        {
            int s = r.nextInt(i+1);
            sh[i] = nums[i];
            int tmp = sh[s];
            sh[s] = sh[i];
            sh[i] = tmp;
        }
        return sh;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */