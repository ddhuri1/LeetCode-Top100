class Solution 
{
    public int majorityElement(int[] nums) 
    {
        /* SLOW
        int len = nums.length;
        if(len == 1) return nums[0];
        int target = len/2;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i]) + 1);
                if(map.get(nums[i]) > target)
                    return  nums[i];
            }
            else
                map.put(nums[i] , 1);
        }
        return res;
        */
        
        int target = 0;
        int result = -1;
        for(int num:nums)
        {
            if(target == 0 )
                result = num;
            if(result == num)
                target += 1;
            else if(result != num)
                target += -1;
        }
        return result;
        
    }
}