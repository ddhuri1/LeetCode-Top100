class Solution 
{
    public int missingNumber(int[] nums)
    {
        int expectedSum = nums.length * (nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums)
            actualSum += num;
        return expectedSum - actualSum;
    }
}

/*SLOW
class Solution 
{
    public int missingNumber(int[] nums) 
    {
        if(nums.length == 0) return 1;
        int i = 0;
        while(i < nums.length)
        {
            if(nums[i] >= 0 && nums[i] < nums.length && nums[i] != nums[nums[i]])
            {
                swap(nums, i, nums[i]);
            }
            else i++;
        }
        
        for(int j = 0; j < nums.length; j ++)
        {
            if(nums[j] != j)
                return j;
        }   
        return nums.length ;
    }
    
    public void swap(int[] A, int i, int j) 
    {
	    int tmp = A[i]; 
        A[i] = A[j];  
        A[j] = tmp;
    }
}*/

/*SLOW 
class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) 
            missing ^= i ^ nums[i];
        return missing;
    }
}*/