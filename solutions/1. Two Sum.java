class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        //1. Brute force
        /*for(int i = 0; i<nums.length; i++)
        {
            for(int j = i+1; j<nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }   
        }
        throw new IllegalArgumentException("No two sum solution");
        */
        
        //2. Optimal A:
        /*HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(target-nums[i], i);
            }
            else
            {
                return new int[] {map.get(nums[i]), i};
            }
        }
        return new int[]{0,0};*/
        
        //3. Optimal B(LEET):98.92%
        /*
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i <nums.length; i++) 
        {
            int difference = target - nums[i];
            if (hash.containsKey(difference)) 
            {
                return new int[] {hash.get(difference),i };
            }
            hash.put(nums[i], i);
           
        }
        throw new IllegalArgumentException("No two sum solution");
        */
        
        //4. 100% opt:
        int[] output = {0, 1};
        
        // We can use this given the req that there is at
        // least one solution
        if(nums.length > 2) {
            Map<Integer, Integer> seekingValues = new HashMap<>(nums.length);
			
            for(int i = nums.length - 1; i >= 0; i--) {
                if(seekingValues.getOrDefault(nums[i], -1) != -1) {
                    output[0] = i; 
                    output[1] = seekingValues.get(nums[i]);
                    break;
                }
                seekingValues.put(target - nums[i], i);
            }
        }
        return output;
    }
}