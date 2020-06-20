class Solution 
{
    public int divide(int dividendI, int ldivisor) 
    {
        long num = 0 , divisor = ldivisor;
        long dividend = dividendI;
        if(dividend == 0) return 0;
        boolean sign = false;
        if(divisor < 0 && dividend < 0)
        {
            divisor = 0 - divisor;
            dividend = 0 - dividend;
        }
        else if(divisor < 0)
        {
            divisor = 0 - divisor;
            sign = true;
        }
        else if(dividend < 0)
        {
            dividend = -dividend;
            sign = true;
        }
        if(dividend < divisor)
            return 0;
        /*while(dividend - divisor >= divisor)
        {
            dividend -= divisor;
            num ++;
        }*/
        
        num = ldivide(dividend, divisor);
        if(!sign && num >= Integer.MAX_VALUE) return  Integer.MAX_VALUE;
        else if(sign && num >= Integer.MAX_VALUE) return  Integer.MIN_VALUE;
        if(!sign) return (int)(num );
        else return (int)(-num);
    }
    
    private long ldivide(long ldividend, long divisor) 
    {
        if (ldividend < divisor) return 0;
        long sum = divisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, divisor);
    }
}