class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int[] result = {-1,-1};
        int left = 0;
        int right = nums.length ;
        
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(target <= nums[mid])
                right = mid;
            else 
                left = mid + 1;
        }
        if((left == right) && (left == nums.length || nums[left] != target))
            return result;
        else
            result[0] = left;
            
        left = 0;
        right = nums.length - 1;
        
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(target < nums[mid])
                right = mid;
            else 
                left = mid + 1;
        }
        
        if(left == right && nums[left] == target)
            result[1] = left;
        else
            result[1] = left - 1;
        return result;        
    }
    
}