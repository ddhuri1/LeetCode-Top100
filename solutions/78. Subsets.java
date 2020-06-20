class Solution
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> subsets = new ArrayList<>();
        backtracking(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }
    
    private void backtracking(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int minIndex)
    {
        subsets.add(new ArrayList<>(subset));
        for(int i = minIndex; i < nums.length; i++)
        {
            subset.add(nums[i]);
            backtracking(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}