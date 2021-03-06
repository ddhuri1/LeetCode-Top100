class Solution
{
    public int trailingZeroes(int n) 
    {
        int count = 0;
        for (long i = 5; i <= n; i *= 5) //multiples of 5 and 10 will have leading zeros
            count += n / i;
        return count;
    }
}