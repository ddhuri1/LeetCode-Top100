class Solution 
{
    public boolean increasingTriplet(int[] nums) 
    {
        int firstMinimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;
        int count=0;
        for(int num: nums)
        {
            if(num < firstMinimum)
            {
                firstMinimum = num;
                count = (count==0)? count+1: count;
            } 
            else
            {
                if(count == 2 && num > secondMinimum)
                    return true;
                else if(num > firstMinimum && num < secondMinimum)
                {
                    secondMinimum = num;
                    count = (count == 1)? count+1: count;
                }
            }
        }
        return false;
    }
}