class Solution 
{
    public int firstMissingPositive(int[] nums) 
    {
        if(nums.length == 0) return 1;
        int i = 0;
        while(i < nums.length)
        {
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1])
            {
                swap(nums, i, nums[i] - 1);
            }
            else i++;
        }
        
        for(int j = 0; j < nums.length; j ++)
        {
            if(nums[j] != j+1)
                return j+1;
        }   
        return nums.length + 1;
    }
    
    public void swap(int[] A, int i, int j) 
    {
	    int tmp = A[i]; 
        A[i] = A[j];  
        A[j] = tmp;
    }
}