class Solution 
{
    public void sortColors(int[] nums) 
    {
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        int i = 0;
        while(i <= ptr2)
        {
            if(nums[i] == 0)
            {
                nums[i] = nums[ptr1];
                nums[ptr1] = 0;
                ptr1++;
            }
            if(nums[i] == 2)
            {
                nums[i] = nums[ptr2];
                nums[ptr2] = 2;
                ptr2--;
                i--;
            }
            i++;
        }
    }
}