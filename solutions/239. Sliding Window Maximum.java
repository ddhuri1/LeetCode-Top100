/* SLOW
public class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        if(nums.length == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int indx = 0;
        for(int i = 0; i < k; i ++)
            queue.add(nums[i]);
        result[indx++] = queue.peek();
        for(int i = k; i < len; i ++)
        {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            result[indx++] = queue.peek();
        }
        return result;
    }
}
*/

class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int curWindow = 0;
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int indx = 0;
        for (int i = 0; i < k; i++)
            if (nums[i] > max)
                max = nums[i];
        
        result[indx++] = max;
        for (int i = k; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i - k] == max)
            {
                max = Integer.MIN_VALUE;
                for (int j = i - k + 1; j <= i; j++)
                    max = Math.max(max, nums[j]);
            }
            result[indx++] = max;
        }
        return result;
    }
}