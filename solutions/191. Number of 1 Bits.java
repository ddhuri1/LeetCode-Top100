public class Solution 
{
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
        
        int sum = 0;
        while (n != 0)
        {
            int anding = n - 1;
            n &= anding;
            sum++;
        }
        return sum;
        
    }
}