public class Solution 
{
    public int reverseBits(int n) 
    {
        int copy = n, result = 0;
        for (int i = 0; i < 32; i++) 
        {
            result <<= 1;
            if ((copy & 1) == 1) 
                result += 1;
            copy >>= 1;
        }
        return result;
    }
}