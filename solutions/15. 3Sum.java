class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        /*
        Map<Integer, Integer> hash = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int j = 0; j< nums.length; j++)
        {
            int target = -nums[j];

            for (int i = 0; i <nums.length; i++) 
            {
                int difference = -(target + nums[i]);
                if (hash.containsKey(difference) && i !=j) 
                {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[hash.get(difference)]);
                    t.add(nums[i]);
                    t.add(nums[j]);
                    list.add(t);
                }
                else if(i !=j)
                    hash.put(difference, i);
            }
        }
        return list;
        */
        
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) 
        {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) 
            {
                int  sum = -nums[i]; 
                int low = i+1, high = nums.length - 1;
                while (low < high) 
                {
                    if(nums[low] + nums[high] < sum) low ++;
                    else if(nums[low] + nums[high] > sum) high --;
                    else if(nums[low] + nums[high] == sum) 
                    {
                        /* Works but takes time 
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[low]);
                        t.add(nums[high]);
                        list.add(t);
                        */
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low ++;
                        while(low < high && nums[high] == nums[high - 1]) high --;
                        low ++;
                        high --;
                    }
                }
            }
        }
        return list;
    }
}