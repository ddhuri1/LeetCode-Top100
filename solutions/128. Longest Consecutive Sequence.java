class Solution
{
    public int longestConsecutive(int[] nums) 
    {
        if(nums == null || nums.length == 0) return 0;
        int max = 1, curr = 1;
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                if(nums[i] - nums[i-1] == 1) {
                    curr++;
                    max = Math.max(max, curr);
                } else {
                    curr = 1;
                }
            }
        }
        return max;
    }
}