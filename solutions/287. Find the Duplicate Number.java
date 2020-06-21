/*Obvious solution: but SLOW
class Solution 
{
    public int findDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) 
        {
            if (set.contains(num)) 
                return num;
            setset.add(num);
        }
        return -1;
    }
}
*/

//Optimal : Floyd's Tortoise and Hare (Cycle Detection)
class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        int slow = nums[0];
        int fast = nums[0];
        do 
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        if (slow == nums[0])
            return nums[0];
        slow = nums[0];
        do 
        {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        
        return slow;
    }
}