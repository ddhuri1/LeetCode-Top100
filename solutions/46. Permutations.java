class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), list);
        return list;
    }
    
    public void backTrack(int[] nums, List<Integer> temp, List<List<Integer>> list)
    {
        if(temp.size() == nums.length) 
            list.add(new ArrayList<>(temp));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(temp.contains(nums[i])) continue; 
                temp.add(nums[i]);
                backTrack(nums, temp, list);
                temp.remove(temp.size() - 1);
            }
        }
    }
}