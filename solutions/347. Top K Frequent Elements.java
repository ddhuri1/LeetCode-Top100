class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        List<Integer>[] fre = new ArrayList[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(i == nums.length - 1 || (nums[i] != nums[i + 1]))
            {
                if(fre[count] == null)
                    fre[count] = new ArrayList<>();
                fre[count].add(nums[i]);
                count = 1;
            }
            else
                count ++;
        }
        
        int cnt = k;
        for(int i = fre.length - 1; i > 0; i--)
        {
            if((fre[i] != null) && cnt > 0)
            {
                for(int item : fre[i])
                {
                    list.add(item);
                    if(--cnt == 0) break;
                }
            }
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = list.get(i);        
        return res;
    }
}